package com.prac26102026.prac1.filter;
import com.prac26102026.prac1.dto.CurrentUserDTO;
import com.prac26102026.prac1.service.impl.UserContextService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;

@Component
public class SmUserFilter extends OncePerRequestFilter {

    private final UserContextService userContextService;

    @Value("${app.security.header-auth-enabled:true}")
    private boolean headerAuthEnabled;

    public SmUserFilter(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // Skip authentication when disabled
        if (!headerAuthEnabled) {
            filterChain.doFilter(request, response);
            return;
        }

        String smUser = request.getHeader("SM_USER");

        if (smUser == null || smUser.isBlank()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\":\"SM_USER header is required\"}"
            );
            return;
        }

        try {
            CurrentUserDTO currentUser =
                    userContextService.validateUser(smUser);

            request.setAttribute("CURRENT_USER", currentUser);

            filterChain.doFilter(request, response);

        } catch (ResponseStatusException ex) {
            response.setStatus(ex.getStatusCode().value());
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\":\"User validation failed\"}"
            );
        }
    }
}