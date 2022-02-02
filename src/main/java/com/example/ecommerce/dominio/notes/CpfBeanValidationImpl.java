package com.example.ecommerce.dominio.notes;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfBeanValidationImpl implements ConstraintValidator<Cpf,String >{

    private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };


    @Override
    public void initialize(Cpf value) {
        // método gerado para implementacao do ConstraintValidator
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return validarCPF(value);
    }

    private boolean validarCPF(String cpf) {
        if ((cpf.length() != 11) || validarSequenciaCaracter(cpf)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        int digito;
        for (int indice = str.length() - 1; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private boolean validarSequenciaCaracter(String documento) {
        String documentoTemp;
        for (int i = 0; i <= 9; i++) {
            documentoTemp = "";
            for (int j = 0; j < 11; j++) {
                documentoTemp += Integer.toString(i);
            }
            if (documento.equals(documentoTemp)) {
                return true;
            }
        }
        return false;
    }
}

