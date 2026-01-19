package main.java.com.sdev.core_concepts_java21.domain.model;

import main.java.com.sdev.core_concepts_java21.domain.exception.DomainException;

public record Email(String value) {

    public Email {
        if (value == null || value.isBlank()) {
            throw new DomainException("El email no puede ser nulo o vacío");
        }

        if (!value.contains("@")) {
            throw new DomainException("Formato de email inválido");
        }
    }
}