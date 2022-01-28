package com.example.ecommerce.dominio;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Item {

    @NotNull(message = "Product is required")
    @NotEmpty(message = "Product is required")
    private Product product;

    private int qtd;

    private Double valorTotalItem;

    public Item(Product product, int qtd, Double valorTotalItem) {
        this.product = product;
        this.qtd = qtd;
        this.valorTotalItem = valorTotalItem;
    }

    public Product getProduct() {
        return product;
    }

    public int getQtd() {
        return qtd;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }
}
