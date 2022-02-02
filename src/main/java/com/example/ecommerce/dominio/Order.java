package com.example.ecommerce.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCompra;

    @NotNull(message = "Provider is required")
    @NotEmpty(message = "Provider is required")
    private Supplier supplier;
    @NotNull(message = "Client is required")
    @NotEmpty(message = "Client is required")
    private Costumer costumer;


    private Double valorTotal;

    private Double valorTotalItens;

    private Double valorFrete;

    @Size(min = 1, message = "Order should have at least 1 item")
    private List<Item> itens;

    public Order(Long id, LocalDateTime dataCompra, Supplier supplier, Costumer costumer, Double valorTotal, Double valorTotalItens, Double valorFrete, List<Item> itens) {
        this.dataCompra = dataCompra;
        this.supplier = supplier;
        this.costumer = costumer;
        this.valorTotal = valorTotal;
        this.valorTotalItens = valorTotalItens;
        this.valorFrete = valorFrete;
        this.itens = itens;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Supplier getProvider() {
        return supplier;
    }

    public Costumer getClient() {
        return costumer;
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
