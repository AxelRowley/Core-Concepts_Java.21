package main.java.com.sdev.core_concepts_java21.application.dto;

import main.java.com.sdev.core_concepts_java21.domain.model.UserRole;

public record CreateUserDTO(
        String name,
        String email,
        UserRole role
) {}
