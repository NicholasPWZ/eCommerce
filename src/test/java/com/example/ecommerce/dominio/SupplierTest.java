package com.example.ecommerce.dominio;

import com.example.ecommerce.infra.Exception.InvalidDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class SupplierTest {
    @Test
    public void ShouldCreateASupplier(){
        Contact contact = new Contact("emailll","phonee");
        Address address = new Address("abc","abc","abc","abc","abc","rs");
        Long id = 1234L;
        Supplier model = new Supplier(contact,address,id,"Fantasy Name","1230912309");

        Assertions.assertEquals(model.getId(),1234L);
        Assertions.assertEquals(model.getCnpj(),"1230912309");
        Assertions.assertEquals(model.getNomeFantasia(),"Fantasy Name");
    }
    @Test
    public void ShouldCreateAInvalidSupplier(){
        Long id = 1234L;
        String nomeFantasia = "";
        String cnpj = "";
        Contact contact = new Contact("","");
        Address address = new Address("","","","","","");
        try {
            Supplier model = new Supplier(contact, address, id, nomeFantasia, cnpj);
        }catch(InvalidDomain e){
            Assertions.assertFalse(e.getMessage().isEmpty());
        }
    }
}
