package com.example.ecommerce.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Supplier extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome Fantasia is required")
    @NotEmpty(message = "Nome Fantasia is required")
    @Size(max = 100, message = "Enter a valid Nome Fantasia")
    private String nomeFantasia;

    @NotNull(message = "CNPJ is required")
    @NotEmpty(message = "CNPJ is required")
    @Size(max = 20, message = "Enter a valid CNPJ")
    private String cnpj;

    public Supplier(Contact contact, Address address, Long id_provider, String nomeFantasia, String cnpj) {
        super(contact, address);
        this.id = id_provider;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }



    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Long getId() {
        return id;
    }
}
