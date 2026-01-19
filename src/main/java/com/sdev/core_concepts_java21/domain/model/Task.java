package main.java.com.sdev.core_concepts_java21.domain.model;

import main.java.com.sdev.core_concepts_java21.domain.exception.DomainException;

import java.time.LocalDate;

public class Task {

    private final Long id;
    private final String title;
    private final String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
    private User assignedUser;

    public Task(
            Long id,
            String title,
            String description,
            TaskPriority priority,
            LocalDate dueDate
    ) {
        if (id == null) {
            throw new DomainException("La tarea debe tener un id");
        }
        if (title == null || title.isBlank()) {
            throw new DomainException("El título no puede estar vacío");
        }

        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority != null ? priority : TaskPriority.MEDIUM;
        this.dueDate = dueDate;
        this.status = TaskStatus.CREATED;
    }

    public void assignTo(User user) {
        if (user == null) {
            throw new DomainException("No se puede asignar la tarea a un usuario nulo");
        }
        if (!user.isActive()) {
            throw new DomainException("No se puede asignar una tarea a un usuario inactivo");
        }

        this.assignedUser = user;
        this.status = TaskStatus.ASSIGNED;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new DomainException("El estado no puede ser nulo");
        }
        this.status = newStatus;
    }

    public void changePriority(TaskPriority priority) {
        if (priority == null) {
            throw new DomainException("La prioridad no puede ser nula");
        }
        this.priority = priority;
    }

    public void cancel() {
        if (this.status == TaskStatus.COMPLETED) {
            throw new DomainException("No se puede cancelar una tarea completada");
        }
        this.status = TaskStatus.CANCELLED;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
}