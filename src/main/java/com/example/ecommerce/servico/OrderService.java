package com.example.ecommerce.servico;

import com.example.ecommerce.dominio.Order;
import com.example.ecommerce.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository repository;
    public OrderService (OrderRepository repository){
        this.repository = repository;
    }
    public void save(Order newOrder){
        repository.save(newOrder);
    }
    public List<Order> findAll(){
     return repository.findAll();

    }
}
