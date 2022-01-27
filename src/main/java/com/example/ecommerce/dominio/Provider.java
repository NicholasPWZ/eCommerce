package com.example.ecommerce.dominio;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Provider extends Person{

    @NotNull(message = "Nome Fantasia is required")
    @NotEmpty(message = "Nome Fantasia is required")
    @Size(max = 100, message = "Enter a valid Nome Fantasia")
    private String nomeFantasia;

    @NotNull(message = "CNPJ is required")
    @NotEmpty(message = "CNPJ is required")
    @Size(max = 20, message = "Enter a valid CNPJ")
    private String cnpj;

    public Provider(String email, String phone, String street, String district, String complement, String cep, String city, String state, String nomeFantasia, String cnpj) {
        super(email, phone, street, district, complement, cep, city, state);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
}
