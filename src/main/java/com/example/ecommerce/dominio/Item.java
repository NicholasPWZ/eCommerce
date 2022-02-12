package com.example.ecommerce.dominio;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;


    @ManyToOne
    @NotNull(message = "Product is required")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull(message = "Quantity is required")
    private int qtd;

    private Double value;

    @Deprecated
    protected Item(){

    }

    public Item(Long id,Product product, int qtd, Double value) {
        this.id = id;
        this.product = product;
        this.qtd = qtd;
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public int getQtd() {
        return qtd;
    }

    public Double getValue() {

        return value = product.getValorUnitario() * qtd;
    }
}
