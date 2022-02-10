package com.example.ecommerce.servico;

import com.example.ecommerce.dominio.Product;
import com.example.ecommerce.infra.Exception.ProductAlreadyRegistered;
import com.example.ecommerce.infra.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;
    public ProductService (ProductRepository repository){
        this.repository = repository;
    }
    public void save(@Valid Product newProduct){
        validateDuplicated(newProduct);
        repository.save(newProduct);
    }
    public void validateDuplicated(Product product){
        int qtd = repository.validateDuplicated(product.getName());
        if(qtd != 0){
            throw new ProductAlreadyRegistered("This product is already registered");
        }
    }
    public List<Product> findAll(){
        return repository.findAll();
    }
}
