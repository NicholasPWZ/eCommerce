package com.example.ecommerce.dominio;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class Order {


    private LocalDateTime dataCompra;

    @NotNull(message = "Provider is required")
    @NotEmpty(message = "Provider is required")
    private Provider provider;
    @NotNull(message = "Client is required")
    @NotEmpty(message = "Client is required")
    private Client client;


    private Double valorTotal;

    private Double valorTotalItens;

    private Double valorFrete;

    @Size(min = 1, message = "Order should have at least 1 item")
    private List<Item> itens;

    public Order(LocalDateTime dataCompra, Provider provider, Client client, Double valorTotal, Double valorTotalItens, Double valorFrete, List<Item> itens) {
        this.dataCompra = dataCompra;
        this.provider = provider;
        this.client = client;
        this.valorTotal = valorTotal;
        this.valorTotalItens = valorTotalItens;
        this.valorFrete = valorFrete;
        this.itens = itens;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Provider getProvider() {
        return provider;
    }

    public Client getClient() {
        return client;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getValorTotalItens() {
        return valorTotalItens;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public List<Item> getItens() {
        return itens;
    }
}
