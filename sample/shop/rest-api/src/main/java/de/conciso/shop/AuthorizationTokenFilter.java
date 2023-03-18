package de.conciso.shop;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthorizationTokenFilter implements Filter {

    private final AuthorizationTokenHolder tokenHolder;

    public AuthorizationTokenFilter(AuthorizationTokenHolder tokenHolder) {
        this.tokenHolder = tokenHolder;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        tokenHolder.setToken(((HttpServletRequest) servletRequest).getHeader("Authorization"));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
