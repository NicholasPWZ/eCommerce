package com.example.ecommerce.dominio;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull(message = "Rua é obrigatória")
    @NotEmpty(message = "Rua é obrigatória")
    @Size(max = 100,message = "Insira um nome de rua válido")
    protected String street;

    @NotNull(message = "Bairro é obrigatório")
    @NotEmpty(message = "Bairro é obrigatório")
    @Size(max = 50, message = "Insira um nome de bairro válido")
    protected String district;

    @Size(max = 120, message = "Insira um complemento válido")
    protected String complement;

    @NotNull(message = "CEP é obrigatório")
    @NotEmpty(message = "CEP é obrigatório")
    @Size(max = 10,message = "Insira um CEP válido")
    protected String cep;

    @NotNull(message = "Cidade é obrigatória")
    @NotEmpty(message = "Cidade é obrigatória")
    @Size(max = 50, message = "Insira um nome de cidade válido")
    protected String city;

    @NotNull(message = "Estado é obrigatório")
    @NotEmpty(message = "Estado é obrigatório")
    @Size(max = 2, message = "Insira uma sigla de estado válida")
    protected String state;

    @Deprecated
    public Address(){

    }
    public Address(String street, String district, String cep, String city, String state) {
        this.street = street;
        this.district = district;
        this.cep = cep;
        this.city = city;
        this.state = state;
    }
    public Address(String street, String district, String complement, String cep, String city, String state) {
        this.street = street;
        this.district = district;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getComplement() {
        return complement;
    }

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
