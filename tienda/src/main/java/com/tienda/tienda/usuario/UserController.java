package com.tienda.tienda.usuario;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/user")
@Validated
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping
    @Transactional
    public void registrarUser(@Valid @RequestBody DatosUser datosUser) {
        System.out.println("llego  los usuarios correcto");
        System.out.println(datosUser);
        userRepository.save(new User(datosUser));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<DatosListadoUser> listarUsuarios() {
        return userRepository.findAll().stream().map(DatosListadoUser::new).toList();
    }

        @CrossOrigin(origins = "http://localhost:4200/")
        @DeleteMapping("/{id}")
        public void eliminarUsuario(@PathVariable Long id){
            User user = userRepository.getReferenceById(id);
            userRepository.delete(user);
            System.out.println("se elimino un usuario");
        }
}
