package com.tienda.tienda.usuario;

public record DatosListadoUser(
        String name,
        String email,
        String phone,
        String phone2,
        boolean state
) {

    public DatosListadoUser( User user){
        this(user.getName(), user.getEmail(), user.getPhone(), user.getPhone2(), user.getState());
    }
}
