package com.example.ecommerce.dominio;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

    @Id
    private long id_product;
    @NotNull(message = "Product name is required")
    @NotEmpty(message = "Product name is required")
    @Size(max = 100,message = "Insert a valid product name")
    private String name;
    @Size(max = 500, message = "Insert a valid description")
    private String description;
    private Double valorUnitario;

    public Product(long id_product, String name, String description, Double valorUnitario) {
        this.id_product = id_product;
        this.name = name;
        this.description = description;
        this.valorUnitario = valorUnitario;
    }

    public long getId_product() {
        return id_product;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }
}
