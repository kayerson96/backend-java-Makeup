package com.tienda.tienda.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;


//este es el modelo que va a mapear las entidades
@Table(name = "user")   // aqui se le intida el nombre de la tabla de DB
@Entity(name = "User")  // aqui se menciona el nombre de la tiendad a mapear
@Getter                   // a traves de lombok se crea los getter
@NoArgsConstructor    // a traves de lombok se crea los contructores
@AllArgsConstructor    // a traves de lombok se indica que se crea constructores sin argumentos
@EqualsAndHashCode(of = "id")         // a traves de lombok  genera automáticamente los métodos equals y hashCode para la clase
public class User  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String usuario;

    private String password;

    private String email;

    private  String phone;

    private String phone2;

    private Boolean state;


    public User(DatosUser datosUser) {
        this.name =datosUser.name();
        this.lastName = datosUser.lastName();
        this.usuario = datosUser.usuario();
        this.password = datosUser.password();
        this.email = datosUser.email();
        this.phone = datosUser.phone();
        this.phone2 = datosUser.phone2();
        this.state = datosUser.state();


    }

    public User(String encode) {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
