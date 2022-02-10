package com.example.ecommerce.api;

import com.example.ecommerce.dominio.Product;
import com.example.ecommerce.servico.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service){
        this.service=service;
    }
    @PostMapping
    public void save(@RequestBody @Valid Product newProduct){
        service.save(newProduct);
    }
    @GetMapping
    public List<Product> find(){
        return service.findAll();
    }
}
