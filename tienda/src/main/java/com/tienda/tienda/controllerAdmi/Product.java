package com.tienda.tienda.controllerAdmi;

import com.tienda.tienda.datos.DatosProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


// este es el mapeo a DB
@Table(name="product")
@Entity(name ="Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String price;

    private String image;

    private String quantity;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    private Category category;


    private boolean state;


    //este constructor viene del Product controller para poder hacer de DatosProduct igual a Product de la iterfaz ya que asi la recibio la interfaz JPA repository
    public Product(DatosProduct datosProduct) {
        this.name =datosProduct.name();
        this.description =datosProduct.description();
        this.price =datosProduct.price();
        this.image =datosProduct.image();
        this.quantity =datosProduct.quantity();
        this.brand =datosProduct.brand();
        this.category =datosProduct.category();
        this.state =datosProduct.state();

    }
}
