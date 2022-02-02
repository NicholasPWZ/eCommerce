package com.example.ecommerce.infra.Exception;

public abstract  class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
