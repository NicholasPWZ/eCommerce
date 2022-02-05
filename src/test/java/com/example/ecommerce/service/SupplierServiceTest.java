package com.example.ecommerce.service;

import com.example.ecommerce.dominio.Address;
import com.example.ecommerce.dominio.Contact;
import com.example.ecommerce.dominio.Supplier;
import com.example.ecommerce.infra.repository.SupplierRepository;
import com.example.ecommerce.servico.SupplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.List;

public class SupplierServiceTest {
    @Mock
    private SupplierRepository repository;
    private SupplierService service;

    @BeforeEach
    public void start(){
        MockitoAnnotations.openMocks(this);
        service = new SupplierService(repository);
    }
    @Test
    public void ShouldSaveASupplier(){
        Contact contact = new Contact("abcd@hotmail.com","5199999999");
        Address address = new Address("street1","district1","complement1","cep1","city","s1");
        var supplier = new Supplier(contact,address,123L,"Fantasy","123112322");
        service.save(supplier);
        Mockito.verify(repository,Mockito.times(1)).save(Mockito.any(Supplier.class));
    }
    @Test
    public void ShouldFindAllSuppliers(){
        Contact contact = new Contact("abcd@hotmail.com","5199999999");
        Address address = new Address("street1","district1","complement1","cep1","city","s1");
        var supplier1 = new Supplier(contact,address,123L,"Fantasy","123112322");
        var supplier = new Supplier(contact,address,123L,"Fantasy","123112322");
        List<Supplier> expectedSuppliers = List.of(supplier1,supplier);
        when(service.findAll()).thenReturn(expectedSuppliers);
        var receivedSuppliers = service.findAll();
        Assertions.assertEquals(expectedSuppliers,receivedSuppliers);
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }
}
