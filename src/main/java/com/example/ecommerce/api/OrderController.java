package com.example.ecommerce.api;

import com.example.ecommerce.dominio.Order;
import com.example.ecommerce.servico.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService service;
    public OrderController(OrderService service){
        this.service = service;
    }
    @PostMapping
    public void save(@RequestBody @Valid Order newOrder){
        service.save(newOrder);

    }
    @GetMapping
    public List<Order> findAll(){
        return service.findAll();
    }
}
