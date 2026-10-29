package com.prac26102026.prac1.filter;


import com.prac26102026.prac1.dto.CurrentUserDTO;
import com.prac26102026.prac1.service.impl.UserContextService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SmUserFilter extends OncePerRequestFilter {

    private final UserContextService userContextService;

    public SmUserFilter(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String smUser = request.getHeader("SM_USER");

        // Reject request if header is missing or blank
        if (smUser == null || smUser.isBlank()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\":\"SM_USER header is required\"}"
            );
            return;
        }

        try {
            // Validate the user and check active status
            CurrentUserDTO currentUser =
                    userContextService.validateUser(smUser);

            request.setAttribute("CURRENT_USER", currentUser);

            // Continue only after successful validation
            filterChain.doFilter(request, response);

        } catch (org.springframework.web.server.ResponseStatusException ex) {
            response.setStatus(ex.getStatusCode().value());
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\":\"" + ex.getStatusCode().value()
                            + " - User validation failed\"}"
            );
        }
    }


//    This is used for Swagger UI and API docs to bypass the filter for those endpoints.
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();

        String path = uri.substring(contextPath.length());

        return path.startsWith("/swagger-ui/")
                || path.equals("/swagger-ui.html")
                || path.startsWith("/v3/api-docs");
    }
}
