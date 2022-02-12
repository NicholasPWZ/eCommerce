package com.example.ecommerce.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Costumer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costumer_id")
    private Long id;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @Size(max = 100, message = "Enter a valid name")
    private String name;

    @NotNull(message = "CPF is required")
    @NotEmpty(message = "CPF is required")
    @Size(max = 20, message = "Enter a valid CPF")
    private String cpf;

    @Deprecated
    protected Costumer(){}

    public Costumer(Contact contact, Address address, Long id, String name, String cpf) {
        super(contact, address);
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        isValid();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }


}
