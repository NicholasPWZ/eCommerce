package com.example.ecommerce.dominio;




import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person {

    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Size(max = 100, message = "Email inválido")
    protected String email;

    @NotNull(message = "Telefone é obrigatório")
    @NotEmpty(message = "Telefone é obrigatório")
    @Size(max = 20,message = "Número de telefone inválido")
    protected String phone;

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



    public Person(String email, String phone, String street, String district, String complement, String cep, String city, String state) {
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.district = district;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
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
