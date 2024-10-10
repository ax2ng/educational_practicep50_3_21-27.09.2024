package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue
    private UUID id;

    @Positive(message = "Количество задач должно быть положительным")
    private int taskCount;

    @Positive(message = "Среднее время выполнения задач должно быть положительным")
    private double averageTaskTime;

    @Positive(message = "Процент выполненных задач должен быть положительным")
    private double completedTaskPercentage;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull(message = "Проект не может быть пустым")
    private Project project;

    public Statistics() {}

    public Statistics(UUID id, int taskCount, double averageTaskTime, double completedTaskPercentage, Project project) {
        this.id = id;
        this.taskCount = taskCount;
        this.averageTaskTime = averageTaskTime;
        this.completedTaskPercentage = completedTaskPercentage;
        this.project = project;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Positive(message = "Количество задач должно быть положительным")
    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(@Positive(message = "Количество задач должно быть положительным") int taskCount) {
        this.taskCount = taskCount;
    }

    @Positive(message = "Среднее время выполнения задач должно быть положительным")
    public double getAverageTaskTime() {
        return averageTaskTime;
    }

    public void setAverageTaskTime(@Positive(message = "Среднее время выполнения задач должно быть положительным") double averageTaskTime) {
        this.averageTaskTime = averageTaskTime;
    }

    @Positive(message = "Процент выполненных задач должен быть положительным")
    public double getCompletedTaskPercentage() {
        return completedTaskPercentage;
    }

    public void setCompletedTaskPercentage(@Positive(message = "Процент выполненных задач должен быть положительным") double completedTaskPercentage) {
        this.completedTaskPercentage = completedTaskPercentage;
    }

    public @NotNull(message = "Проект не может быть пустым") Project getProject() {
        return project;
    }

    public void setProject(@NotNull(message = "Проект не может быть пустым") Project project) {
        this.project = project;
    }
}