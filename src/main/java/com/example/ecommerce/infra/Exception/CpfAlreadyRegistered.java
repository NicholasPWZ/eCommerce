package com.example.ecommerce.infra.Exception;

public class CpfAlreadyRegistered extends BusinessException{
    public CpfAlreadyRegistered(String message) {
        super(message);
    }
}
