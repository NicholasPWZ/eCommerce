package com.example.ecommerce.dominio;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Contact {
    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Size(max = 100, message = "Email inválido")
    protected String email;

    @NotNull(message = "Telefone é obrigatório")
    @NotEmpty(message = "Telefone é obrigatório")
    @Size(max = 20,message = "Número de telefone inválido")
    protected String phone;

    @Deprecated
    public Contact(){}

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
