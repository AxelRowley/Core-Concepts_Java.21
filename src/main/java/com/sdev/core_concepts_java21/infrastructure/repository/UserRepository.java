package main.java.com.sdev.core_concepts_java21.infrastructure.repository;

import main.java.com.sdev.core_concepts_java21.domain.model.Email;
import main.java.com.sdev.core_concepts_java21.domain.model.User;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
    boolean existsByEmail(Email email);
}