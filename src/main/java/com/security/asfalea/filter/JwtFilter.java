package com.security.asfalea.filter;

import com.security.asfalea.exception.TokenExpiredException;
import com.security.asfalea.exception.UnauthorizedException;
import com.security.asfalea.jwt.JwtService;
import com.security.asfalea.service.MyUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                userName = jwtService.extractUserName(token);
            }

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = context.getBean(MyUserDetailService.class).loadUserByUsername(userName);

                if (jwtService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    throw new UnauthorizedException("Invalid JWT token.");
                }
            }
        } catch (TokenExpiredException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token expired.");
            log.error("JWT token expired: {}", e.getMessage());
            return; // Stop further processing
        } catch (UnauthorizedException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized access.");
            log.error("Unauthorized access: {}", e.getMessage());
            return; // Stop further processing
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access denied.");
            log.error("Security error: {}", e.getMessage());
            return; // Stop further processing
        }

        filterChain.doFilter(request, response);
    }
}
