package com.tienda.tienda.controllerAdmi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/tienda")
public class controllerAdmi {

    @GetMapping
    public String hello(){
        return "hello world des aqui**";
    }



}
