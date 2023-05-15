package com.tienda.tienda.security;

import com.tienda.tienda.usuario.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;



@WebFilter(urlPatterns = {"v2/api/"})
  @Component
public class SecurityFilter  extends OncePerRequestFilter  {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;


    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("el filtro esta siendo llamado");
        // Obtener el token del header
    var authHeader = request.getHeader("Authorization");

        System.out.println("llego aqui " );
    if (authHeader != null) {
        System.out.println("entro aqui " );
        var token = authHeader.replace("Bearer ", "");
        var nombreUsuario = tokenService.getSubject(token); // extract username
        if (nombreUsuario != null) {
            // Token valido
            System.out.println("llego aqui3");
            var usuario = userRepository.findByUsuario(nombreUsuario);
            System.out.println("llego aqui 4");
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                    usuario.getAuthorities()); // Forzamos un inicio de sesion
            System.out.println("llego aqui 5");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    else {
        System.out.println("hubo un error y no paso el filtro");
    }
    filterChain.doFilter(request, response);
        System.out.println("se llama al filtro correctamente");
}
}

