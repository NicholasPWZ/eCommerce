package com.example.ecommerce.infra.Exception;

import com.example.ecommerce.infra.Exception.BusinessException;

import java.util.Set;

public class InvalidDomain extends BusinessException {
    public InvalidDomain(Set<String> messages) {
        super(messages.toString());
    }

    public InvalidDomain(String messages) {
        super(messages);
    }
}
