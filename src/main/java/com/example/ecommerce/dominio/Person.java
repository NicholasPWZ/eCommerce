package com.example.ecommerce.dominio;




import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
public abstract class Person extends EntityClass {
    @Valid
    @NotNull(message = "Contato é obrigatório")
    public Contact contact;
    @Valid
    @NotNull(message = "Endereço é obrigatório")
    public Address address;

    @Deprecated
    public Person(){}

    public Person(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAdress() {
        return address;
    }
}
