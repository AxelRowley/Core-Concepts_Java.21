package main.java.com.sdev.core_concepts_java21.domain.model;

import main.java.com.sdev.core_concepts_java21.domain.exception.DomainException;

public class User {

    private final Long id;
    private final String name;
    private final Email email;
    private final UserRole role;
    private boolean active;

    public User(Long id, String name, Email email, UserRole role) {
        if (id == null) {
            throw new DomainException("El usuario debe tener un id");
        }
        if (name == null || name.isBlank()) {
            throw new DomainException("El nombre no puede estar vacío");
        }
        if (email == null) {
            throw new DomainException("El email no puede ser nulo");
        }
        if (role == null) {
            throw new DomainException("El rol no puede ser nulo");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.active = true;
    }

    public void deactivate() {
        if (!active) {
            throw new DomainException("El usuario ya está desactivado");
        }
        this.active = false;
    }

    public void activate() {
        if (active) {
            throw new DomainException("El usuario ya está activo");
        }
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }
}