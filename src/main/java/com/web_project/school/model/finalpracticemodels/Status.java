package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Название статуса не может быть пустым")
    @Size(max = 50, message = "Название статуса не должно превышать 50 символов")
    private String statusName;

    @NotBlank(message = "Приоритет не может быть пустым")
    @Size(max = 20, message = "Приоритет не должен превышать 20 символов")
    private String priority;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Status() {}

    public Status(UUID id, String statusName, String priority, List<Project> projects, List<Task> tasks) {
        this.id = id;
        this.statusName = statusName;
        this.priority = priority;
        this.projects = projects;
        this.tasks = tasks;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}