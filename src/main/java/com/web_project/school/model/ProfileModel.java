package com.web_project.school.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profiles")
public class ProfileModel {
    @Id
    @GeneratedValue
    private UUID id;

    private String bio; // Краткая информация о студенте

    @OneToOne(mappedBy = "profile") // Связь с StudentModel
    private StudentModel student;

    public ProfileModel() {}

    public ProfileModel(UUID id, String bio, StudentModel student) {
        this.id = id;
        this.bio = bio;
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }
}