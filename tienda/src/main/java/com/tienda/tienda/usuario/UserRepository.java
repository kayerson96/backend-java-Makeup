package com.tienda.tienda.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

//aqui se esta utilizando la persistencia donde se toma el model User y al llamar unas de las funciones de JpaRepository se guardara en DB
public interface UserRepository  extends JpaRepository<User, Long> {
    UserDetails findByUsuario(String usuario);
}


