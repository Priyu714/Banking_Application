package com.webapp.banking_application.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /*
     *  Filter class that handles JWT authentication and authorization for each request.
     * */

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestTokenHeader =request.getHeader("Authorization");
        String username = null;
        String token = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")){
            token = requestTokenHeader.substring(7);
            try{
                username =this.jwtTokenUtil.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e){
                System.out.println("unable to get token");
            }catch (ExpiredJwtException e){
                System.out.println("JWT Token Ecpired..");
            }catch (MalformedJwtException e){
                System.out.println("Malformed JWT token");
            }
        }else {
            System.out.println("JWT Token does not begin with bearer string");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() ==null){

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if(this.jwtTokenUtil.validationToken(token,userDetails)){

                System.out.println("userDetails.getAuthorities() :"+userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userDetails,
                        null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }else {
                System.out.println("Invalid JWT Token");
            }
        }else {
            System.out.println("User not found or security context is not null");
        }
        filterChain.doFilter(request,response);
    }
}
