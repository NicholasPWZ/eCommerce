package com.example.ecommerce.api;

import com.example.ecommerce.dominio.Supplier;
import com.example.ecommerce.servico.SupplierService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierControler {
    private SupplierService service;
    public SupplierControler(SupplierService service){
        this.service = service;
    }
    @PostMapping
    public void save(@RequestBody @Valid Supplier newSupplier){
        service.save(newSupplier);
    }
    @GetMapping
    public List<Supplier> findAll(){
        return service.findAll();
    }
}
