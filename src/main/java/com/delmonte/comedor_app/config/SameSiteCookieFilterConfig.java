package com.delmonte.comedor_app.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SameSiteCookieFilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);

        if (response instanceof HttpServletResponse) {
            HttpServletResponse res = (HttpServletResponse) response;
            for (String header : res.getHeaders("Set-Cookie")) {
                if (header.contains("JSESSIONID")) {
                    String newHeader = header + "; SameSite=None; Secure";
                    res.setHeader("Set-Cookie", newHeader);
                }
            }
        }
    }
}
