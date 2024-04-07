package com.webapp.banking_application.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private String secret = "jwtTokenKey";
    
    
    public boolean validationToken(String token, UserDetails userDetails) {
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private String getClaimFromToken(String token, Object getSubject) {
    }
}
