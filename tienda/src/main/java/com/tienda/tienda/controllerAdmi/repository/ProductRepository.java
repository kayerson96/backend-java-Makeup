package com.tienda.tienda.controllerAdmi.repository;


import com.tienda.tienda.controllerAdmi.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//esto es lo que va a generar la interfaz para hacer lo query y insertar la informacion en la  base de datos, esto ayuda a no tener
//que abrir y cerrar bases de datos ni crear el patron DAO, esto lo hace "automatico"
                                    //esta interfas JpaRepository es propia de sprintData  y recibe dos parametros
                                                //el 1 es el tipo de objeto a guardar
                                                    //2 el tipo de objeto del ID
public interface ProductRepository extends JpaRepository <Product, Long> {
}
