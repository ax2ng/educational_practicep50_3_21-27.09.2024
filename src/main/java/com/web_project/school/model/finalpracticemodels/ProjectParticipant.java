//package com.web_project.school.model.finalpracticemodels;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//import java.util.UUID;
//
//@Entity
//@Table(name = "project_participants")
//public class ProjectParticipant {
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "project_id", nullable = false)
//    @NotNull(message = "Проект не может быть пустым")
//    private Project project;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    @NotNull(message = "Сотрудник не может быть пустым")
//    private Employee employee;
//
//    public ProjectParticipant() {}
//
//    public ProjectParticipant(UUID id, Project project, Employee employee) {
//        this.id = id;
//        this.project = project;
//        this.employee = employee;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//}