package com.tienda.tienda.controllerAdmi;

import com.tienda.tienda.controllerAdmi.repository.ProductRepository;
import com.tienda.tienda.datos.DatosListadoProduct;
import com.tienda.tienda.datos.DatosProduct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("API/products")
public class ProductController {

    //controlador


                //con esta linea   private ProductRepository productRepository; estoy inyectando o llamado
                        //la interfaz y usamos autowired para no tener que crear uno nuevo
            //autowired no es recomendable por fines de testing a nivel de la declaracion para pruebas unitarias
        @Autowired
        private ProductRepository productRepository;
        @PostMapping
        @Transactional
        public void registrarProducto(@RequestBody DatosProduct datosProduct){

            System.out.println("llego correcto");
            productRepository.save(new Product(datosProduct) );

            //productRepository es el que ejecuta el Query y lo guarda y crea un nuevo producto
            //del model producto lo cual lo hace igual a los datosProduct que lo toma de postman o la Api



        }



    @CrossOrigin(origins = "*")
    @GetMapping
    public List<DatosListadoProduct> obtenerAllProductos(){
        return productRepository.findAll().stream().map(DatosListadoProduct::new).toList();
    }

    @DeleteMapping("/{id}")
    public void EliminarProducto(@PathVariable Long id){
 Product product = productRepository.getReferenceById(id);
 productRepository.delete(product);
        System.out.println("se elimino el producto");
    };

}

