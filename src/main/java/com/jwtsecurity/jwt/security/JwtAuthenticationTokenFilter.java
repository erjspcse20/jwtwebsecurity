package com.jwtsecurity.jwt.security;

import com.jwtsecurity.jwt.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    public JwtAuthenticationTokenFilter(){
        super("/rest/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
       String header = httpServletRequest.getHeader("Authorisation");
       if(header==null || !header.startsWith("Token ")){
           throw new RuntimeException("JWT Token Is Missing");
       }

       String auththenticationToken = header.substring(6);

        JwtAuthenticationToken token = new JwtAuthenticationToken(auththenticationToken);

        return getAuthenticationManager().authenticate(token);
    }

}