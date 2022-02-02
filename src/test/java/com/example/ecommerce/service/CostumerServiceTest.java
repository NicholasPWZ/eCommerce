package com.example.ecommerce.service;

import com.example.ecommerce.dominio.Address;
import com.example.ecommerce.dominio.Contact;
import com.example.ecommerce.dominio.Costumer;
import com.example.ecommerce.infra.repository.CostumerRepository;
import com.example.ecommerce.servico.CostumerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.List;

public class CostumerServiceTest {
    @Mock
    private CostumerRepository repository;
    private CostumerService service;

    @BeforeEach
    public void start(){
        MockitoAnnotations.openMocks(this);
        service = new CostumerService(repository);
    }
    @Test
    public void shouldSaveACostumer(){
        Contact contact = new Contact("abcd@hotmail.com","5199999999");
        Address address = new Address("street1","district1","complement1","cep1","city","s1");
        var costumer = new Costumer(contact, address,1234L,"name costumer","10290921122");
        service.save(costumer);
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Costumer.class));
    }

    @Test
    public void shouldFindAll(){
        Contact contact = new Contact("abcd@hotmail.com","5199999999");
        Address address = new Address("street1","district1","complement1","cep1","city","s1");
        var costumer1 = new Costumer(contact, address,1234L,"costumer","12345665433");
        var costumer2 = new Costumer(contact, address,1234L,"costumer","12345665433");
        List<Costumer> expectedCostumers = List.of(costumer1,costumer2);
        when(service.find()).thenReturn(expectedCostumers);
        var receivedCostumers = service.find();
        Assertions.assertEquals(expectedCostumers,receivedCostumers);
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }
}
