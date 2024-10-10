package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Название задачи не может быть пустым")
    @Size(max = 100, message = "Название проекта не должно превышать 100 символов")
    private String taskName;

    @NotBlank(message = "Описание задачи не может быть пустым")
    @Size(max = 500, message = "Описание проекта не должно превышать 500 символов")
    private String taskDescription;

    @FutureOrPresent(message = "Дата должна быть сегодня или в будущем")
    @NotNull(message = "Дата начала не может быть пустой")
    private LocalDate startDate;

    @FutureOrPresent(message = "Дата должна быть сегодня или в будущем")
    @NotNull(message = "Дата окончания не может быть пустой")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull(message = "Проект не может быть пустым")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull(message = "Статус не может быть пустым")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private Chat chat;


    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL) // Указываем, что эта связь управляется StudentModel
    private List<Employee> employees; // Список студентов, которые имеют этот продукт


    public Task() {}

    public Task(UUID id, String taskName, String taskDescription, LocalDate startDate, LocalDate endDate, Project project, Status status, Chat chat, List<Employee> employees) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = project;
        this.status = status;
        this.chat = chat;
        this.employees = employees;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Название задачи не может быть пустым") @Size(max = 100, message = "Название проекта не должно превышать 100 символов") String getTaskName() {
        return taskName;
    }

    public void setTaskName(@NotBlank(message = "Название задачи не может быть пустым") @Size(max = 100, message = "Название проекта не должно превышать 100 символов") String taskName) {
        this.taskName = taskName;
    }

    public @NotBlank(message = "Описание задачи не может быть пустым") @Size(max = 500, message = "Описание проекта не должно превышать 500 символов") String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(@NotBlank(message = "Описание задачи не может быть пустым") @Size(max = 500, message = "Описание проекта не должно превышать 500 символов") String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public @FutureOrPresent(message = "Дата должна быть сегодня или в будущем") @NotNull(message = "Дата начала не может быть пустой") LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@FutureOrPresent(message = "Дата должна быть сегодня или в будущем") @NotNull(message = "Дата начала не может быть пустой") LocalDate startDate) {
        this.startDate = startDate;
    }

    public @FutureOrPresent(message = "Дата должна быть сегодня или в будущем") @NotNull(message = "Дата окончания не может быть пустой") LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@FutureOrPresent(message = "Дата должна быть сегодня или в будущем") @NotNull(message = "Дата окончания не может быть пустой") LocalDate endDate) {
        this.endDate = endDate;
    }

    public @NotNull(message = "Проект не может быть пустым") Project getProject() {
        return project;
    }

    public void setProject(@NotNull(message = "Проект не может быть пустым") Project project) {
        this.project = project;
    }

    public @NotNull(message = "Статус не может быть пустым") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Статус не может быть пустым") Status status) {
        this.status = status;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}