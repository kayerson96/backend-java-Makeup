package com.tienda.tienda.datos;

import com.tienda.tienda.controllerAdmi.Brand;
import com.tienda.tienda.controllerAdmi.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



//estos son los datos que se reciben de la API
public record DatosProduct(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        String price,
        @NotNull
        String image,
        @NotBlank
        String quantity,
        @NotNull
        Brand brand,
        @NotNull
        Category category,

        @NotBlank
        Boolean state

                            )
{
}
