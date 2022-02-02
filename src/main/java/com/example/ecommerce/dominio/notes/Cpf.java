package com.example.ecommerce.dominio.notes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CpfBeanValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {

    String message() default "CPF deve ser valido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}