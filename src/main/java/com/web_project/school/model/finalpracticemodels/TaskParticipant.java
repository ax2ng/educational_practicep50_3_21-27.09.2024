//package com.web_project.school.model.finalpracticemodels;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//import java.util.UUID;
//
//@Entity
//@Table(name = "task_participants")
//public class TaskParticipant {
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "task_id", nullable = false)
//    @NotNull(message = "Задача не может быть пустой")
//    private Task task;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    @NotNull(message = "Сотрудник не может быть пустым")
//    private Employee employee;
//
//    public TaskParticipant() {}
//
//    public TaskParticipant(UUID id) {
//        this.id = id;
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
//    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
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