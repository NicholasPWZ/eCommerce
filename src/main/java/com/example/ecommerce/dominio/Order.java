package com.example.ecommerce.dominio;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime dataCompra;

    @Valid
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @NotNull(message = "Supplier is required")
    private Supplier supplier;

    @Valid
    @ManyToOne
    @JoinColumn(name = "costumer_id")
    @NotNull(message = "Costumer is required")
    private Costumer costumer;


    private Double valorTotal;

    private Double valorTotalItens;

    private Double valorFrete;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    private List<Item> itens = new ArrayList<>();

    @Deprecated
    public Order(){

    }
    public Order(Long id, Supplier supplier, Costumer costumer, Double valorTotal, Double valorTotalItens, Double valorFrete, Item item) {
        this.id = id;
        this.dataCompra = LocalDateTime.now();
        this.supplier = supplier;
        this.costumer = costumer;
        this.valorTotal = valorTotal;
        this.valorTotalItens = valorTotalItens;
        this.valorFrete = valorFrete;
        addItem(item);
    }
    public Long id (){return id;}

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public Double getValorTotal() {
        return getValorFrete() + getValorTotalItens();
    }

    public Double getValorTotalItens() {
        double value = 0;
        for(Item item : itens){
            value += item.getValue();
        }

        return value;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public List<Item> getItens() {
        return itens;
    }
    public void addItem(Item item){
        if (item == null){
            return;
        }
        this.itens.add(item);
    }
}
