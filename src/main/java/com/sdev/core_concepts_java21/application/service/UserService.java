package main.java.com.sdev.core_concepts_java21.application.service;

import main.java.com.sdev.core_concepts_java21.domain.exception.DomainException;
import main.java.com.sdev.core_concepts_java21.domain.model.Email;
import main.java.com.sdev.core_concepts_java21.domain.model.User;
import main.java.com.sdev.core_concepts_java21.domain.model.UserRole;
import main.java.com.sdev.core_concepts_java21.infrastructure.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(Long id, String name, String email, UserRole role) {
        Email emailVO = new Email(email);

        if (userRepository.existsByEmail(emailVO)) {
            throw new DomainException("Ya existe un usuario con ese email");
        }

        User user = new User(id, name, emailVO, role);
        userRepository.save(user);
    }

    public void deactivateUser(Long id) {
        User user = userRepository.findById(id);
        user.deactivate();
    }
}
