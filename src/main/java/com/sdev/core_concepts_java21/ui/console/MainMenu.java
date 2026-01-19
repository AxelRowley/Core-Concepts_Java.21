package main.java.com.sdev.core_concepts_java21.ui.console;

import main.java.com.sdev.core_concepts_java21.application.service.UserService;
import main.java.com.sdev.core_concepts_java21.domain.model.UserRole;
import main.java.com.sdev.core_concepts_java21.infrastructure.repository.InMemoryUserRepository;

public class MainMenu {

    public static void main(String[] args) {

        UserService userService =
                new UserService(new InMemoryUserRepository());

        userService.registerUser(
                1L,
                "Axel",
                "axel@email.com",
                UserRole.ADMIN
        );

        System.out.println("Usuario registrado correctamente");
    }
}