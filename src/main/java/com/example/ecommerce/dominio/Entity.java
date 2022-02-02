package com.example.ecommerce.dominio;

import com.example.ecommerce.infra.Exception.InvalidDomain;

import javax.persistence.MappedSuperclass;
import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class Entity {
    public void isValid() {
        Configuration<?> configuracaoes = Validation.byDefaultProvider().configure();
        ValidatorFactory fabrica = configuracaoes.buildValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<Entity>> regrasVioladas = validador.validate(this);

        Set<String> messages = new HashSet<>();

        for (ConstraintViolation<Entity> constraintViolation : regrasVioladas) {
            String campo = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            messages.add(campo.concat(" : ").concat(msg));
        }

        if (!messages.isEmpty()) {
            throw new InvalidDomain(messages);
        }
    }
}
