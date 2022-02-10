package com.example.ecommerce.infra.Exception;

public class ProductAlreadyRegistered extends BusinessException{
    public ProductAlreadyRegistered(String message) {
        super(message);
    }
}
