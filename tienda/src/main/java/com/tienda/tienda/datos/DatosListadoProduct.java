package com.tienda.tienda.datos;

import com.tienda.tienda.controllerAdmi.Brand;
import com.tienda.tienda.controllerAdmi.Category;
import com.tienda.tienda.controllerAdmi.Product;

public record DatosListadoProduct(Long id, String name, String description, String price, Brand brand, Category category, String image) {

    public DatosListadoProduct(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getBrand(), product.getCategory(), product.getImage());
    }
}
