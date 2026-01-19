package main.java.com.sdev.core_concepts_java21.application.dto;

import main.java.com.sdev.core_concepts_java21.domain.model.TaskPriority;
import main.java.com.sdev.core_concepts_java21.domain.model.TaskStatus;

public record TaskResponseDTO(
        Long id,
        String title,
        TaskStatus status,
        TaskPriority priority
) {}
