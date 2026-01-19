package main.java.com.sdev.core_concepts_java21.domain.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}