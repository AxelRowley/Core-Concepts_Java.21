package main.java.com.sdev.core_concepts_java21.infrastructure.repository;

import main.java.com.sdev.core_concepts_java21.domain.exception.DomainException;
import main.java.com.sdev.core_concepts_java21.domain.model.Email;
import main.java.com.sdev.core_concepts_java21.domain.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> storage = new HashMap<>();

    @Override
    public void save(User user) {
        storage.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        User user = storage.get(id);
        if (user == null) {
            throw new DomainException("Usuario no encontrado");
        }
        return user;
    }

    @Override
    public boolean existsByEmail(Email email) {
        return storage.values().stream()
                .anyMatch(u -> u.getEmail().equals(email));
    }
}