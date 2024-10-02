package com.web_project.school.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne // Заказ может принадлежать одному студенту
    @JoinColumn(name = "student_id", nullable = false) // Внешний ключ для связи с StudentModel
    private StudentModel student;

    // Другие поля, такие как номер заказа, дата и т.д.
    private String orderNumber; // Пример поля номера заказа
    private double totalAmount; // Пример поля для суммы заказа

    public OrderModel() {}

    public OrderModel(UUID id, StudentModel student, String orderNumber, double totalAmount) {
        this.id = id;
        this.student = student;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}