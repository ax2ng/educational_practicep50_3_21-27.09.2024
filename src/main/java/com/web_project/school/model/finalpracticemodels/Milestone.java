package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "milestones")
public class Milestone {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Название этапа не может быть пустым")
    private String milestoneName;

    @NotNull(message = "Дата достижения не может быть пустой")
    private Date achievementDate;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull(message = "Проект не может быть пустым")
    private Project project;

    public Milestone() {}

    public Milestone(UUID id, String milestoneName, Date achievementDate, Project project) {
        this.id = id;
        this.milestoneName = milestoneName;
        this.achievementDate = achievementDate;
        this.project = project;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public Date getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(Date achievementDate) {
        this.achievementDate = achievementDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}