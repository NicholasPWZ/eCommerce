package com.example.ecommerce.service;

import com.example.ecommerce.dominio.Product;
import com.example.ecommerce.infra.repository.ProductRepository;
import com.example.ecommerce.servico.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class ProductServiceTest {
    @Mock
    private ProductRepository repository;
    private ProductService service;
    @BeforeEach
    public void start(){
        MockitoAnnotations.openMocks(this);
        service = new ProductService(repository);
    }
    @Test
    public void shouldSaveAProduct(){
        Long id = 1234L;
        String name = "product";
        String description = "description";
        Double value = 99.99;

        Product model = new Product(id,name,description,value);
        Assertions.assertEquals(model.getId(),id);
        Assertions.assertEquals(model.getName(),name);
        Assertions.assertEquals(model.getDescription(),description);
        Assertions.assertEquals(model.getValorUnitario(),value);

    }
    @Test
    public void shouldFindAll(){
        Long id = 1234L;
        String name = "product";
        String description = "description";
        Double value = 99.99;
        var model1 = new Product(id,name,description,value);
        var model2 = new Product(id,name,description,value);
        List<Product> expectedProducts = List.of(model1,model2);
        when(service.findAll()).thenReturn(expectedProducts);
        var receivedProducts = service.findAll();
        Assertions.assertEquals(expectedProducts,receivedProducts);
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }
}
