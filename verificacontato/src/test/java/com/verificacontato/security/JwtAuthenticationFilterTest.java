package com.verificacontato.security;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;



import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtAuthenticationFilterTest {

    private JwtAuthenticationFilter filter;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain filterChain;

    @BeforeEach
    public void setup() {
        filter = new JwtAuthenticationFilter();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        filterChain = mock(FilterChain.class);

        SecurityContextHolder.clearContext();
    }

    @Test
    public void testDoFilterInternal_withValidToken() throws Exception {
        String token = "valid.token.jwt";
        String username = "usuario123";

        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        try (MockedStatic<JwtUtil> jwtUtilMock = mockStatic(JwtUtil.class)) {
            jwtUtilMock.when(() -> JwtUtil.isTokenValid(token)).thenReturn(true);
            jwtUtilMock.when(() -> JwtUtil.getUsernameFromToken(token)).thenReturn(username);

            filter.doFilterInternal(request, response, filterChain);

            // Verifica se a autenticação foi colocada no contexto
            assertNotNull(SecurityContextHolder.getContext().getAuthentication());
            assertEquals(username, SecurityContextHolder.getContext().getAuthentication().getPrincipal());

            verify(filterChain).doFilter(request, response);
        }
    }

    @Test
    public void testDoFilterInternal_withoutToken() throws Exception {
        when(request.getHeader("Authorization")).thenReturn(null);

        filter.doFilterInternal(request, response, filterChain);

        // Como não tem token, o contexto de segurança deve estar vazio
        assertNull(SecurityContextHolder.getContext().getAuthentication());

        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testDoFilterInternal_withInvalidToken() throws Exception {
        String token = "invalid.token.jwt";

        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        try (MockedStatic<JwtUtil> jwtUtilMock = mockStatic(JwtUtil.class)) {
            jwtUtilMock.when(() -> JwtUtil.isTokenValid(token)).thenReturn(false);

            filter.doFilterInternal(request, response, filterChain);

            // Contexto de segurança vazio pois token inválido
            assertNull(SecurityContextHolder.getContext().getAuthentication());

            verify(filterChain).doFilter(request, response);
        }
    }
}
