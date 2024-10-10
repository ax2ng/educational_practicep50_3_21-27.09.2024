package com.web_project.school.model.finalpracticemodels;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.StudentModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Название проекта не может быть пустым")
    @Size(max = 100, message = "Название проекта не должно превышать 100 символов")
    private String projectName;

    @NotBlank(message = "Описание проекта не может быть пустым")
    @Size(max = 500, message = "Описание проекта не должно превышать 500 символов")
    private String projectDescription;

    @FutureOrPresent(message = "Дата должна быть сегодня или в будущем")
    @NotNull(message = "Дата начала не может быть пустой")
    private LocalDate startDate;

    @FutureOrPresent(message = "Дата должна быть сегодня или в будущем")
    @NotNull(message = "Дата окончания не может быть пустой")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull(message = "Статус не может быть пустым")
    private Status status;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Milestone> milestones;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Statistics> statistics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private Chat chat;

    // Связь многие ко многим с StudentModel через промежуточную таблицу
    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL) // Указываем, что эта связь управляется StudentModel
    private List<Employee> employees; // Список студентов, которые имеют этот продукт

    public Project() {}

    public Project(UUID id, String projectName, String projectDescription, LocalDate startDate, LocalDate endDate, Status status, List<Task> tasks, List<Milestone> milestones, List<Statistics> statistics, Chat chat, List<Employee> employees) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.tasks = tasks;
        this.milestones = milestones;
        this.statistics = statistics;
        this.chat = chat;
        this.employees = employees;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Название проекта не может быть пустым") @Size(max = 100, message = "Название проекта не должно превышать 100 символов") String getProjectName() {
        return projectName;
    }

    public void setProjectName(@NotBlank(message = "Название проекта не может быть пустым") @Size(max = 100, message = "Название проекта не должно превышать 100 символов") String projectName) {
        this.projectName = projectName;
    }

    public @NotBlank(message = "Описание проекта не может быть пустым") @Size(max = 500, message = "Описание проекта не должно превышать 500 символов") String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(@NotBlank(message = "Описание проекта не может быть пустым") @Size(max = 500, message = "Описание проекта не должно превышать 500 символов") String projectDescription) {
        this.projectDescription = projectDescription;
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

    public @NotNull(message = "Статус не может быть пустым") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Статус не может быть пустым") Status status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
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