package com.tienda.tienda.usuario;

import jakarta.validation.constraints.*;


//estos son los datos que se reciben de la API

public record DatosUser(
        @NotBlank( message = "el campo nombre es requerido")
        String name,
        @NotNull(message = "el campo apellido es requerido")
        String lastName,
        @NotBlank (message = "el campo usuario es requerido")
        String usuario,
        @NotBlank (message = "el campo password es requerido")
        String password,
        @Email (message = "el campo email no cumple con el criterio")
                @NotBlank(message = "el campo email es requerido")
        String email,
        @Pattern(regexp = "\\d{10}", message = ("debe contener 10 digitos"))
        @NotBlank(message = ("debe contener 10 digitos"))
        String phone,

        String phone2,
        Boolean state
) {
}
