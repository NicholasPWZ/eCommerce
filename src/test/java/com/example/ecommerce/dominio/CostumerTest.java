package com.example.ecommerce.dominio;

import com.example.ecommerce.infra.Exception.InvalidDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CostumerTest {
    @Test
    public void shouldCreateAClientSuccessfully(){
        Long id_client = 12456L;
        String name = "Perry ornintorrinco";
        String cpf = "09878790211";
        Contact contact = new Contact("emailll","phonee");
        Address address = new Address("abc","abc","abc","abc","abc","rs");



        Costumer model = new Costumer(contact, address,id_client,name,cpf);

        Assertions.assertEquals(12456L,model.getId());
        Assertions.assertEquals("Perry ornintorrinco",model.getName());
        Assertions.assertEquals("09878790211",model.getCpf());

    }
    @Test
    public void shouldCreateAInvalidClientSuccessfully(){
        Long id = 12456L;
        String name = "";
        String cpf = "";
        Contact contact = new Contact("","");
        Address address = new Address("","","","","","");

        try {
            Costumer model = new Costumer(contact, address,id,name,cpf);
        }catch (InvalidDomain e){
            String message = "[adress.city : Cidade é obrigatória, contact.email : Email é obrigatório, adress.street : Rua é obrigatória, name : Name is required, adress.district : Bairro é obrigatório, adress.cep : CEP é obrigatório, cpf : CPF is required, contact.phone : Telefone é obrigatório, adress.state : Estado é obrigatório]";
            Assertions.assertEquals(e.getMessage(), message);

        }
    }

}
