/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        // expects the token to come from header
        String authHeader = httpServletRequest.getHeader("Authorization");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            //If token is not coming than set the response status as UNAUTHORIZED
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(httpServletRequest,httpServletResponse);

        } else {//extract token from the header

            String jwtToken = authHeader.substring(7);//Bearer => 6+1 since token begins with Bearer
            //token validation
            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwtToken).getBody();
            httpServletRequest.setAttribute("claims", claims);
            // pass the claims in the request
            filterChain.doFilter(servletRequest, servletResponse); //some more filters , controller}

        }
    }
}
