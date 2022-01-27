package com.example.ecommerce.dominio;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Client extends Person {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @Size(max = 100, message = "Enter a valid name")
    private String name;

    @NotNull(message = "CPF is required")
    @NotEmpty(message = "CPF is required")
    @Size(max = 20, message = "Enter a valid CPF")
    private String cpf;

    public Client(String email, String phone, String street, String district, String complement, String cep, String city, String state, String name, String cpf) {
        super(email, phone, street, district, complement, cep, city, state);
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
