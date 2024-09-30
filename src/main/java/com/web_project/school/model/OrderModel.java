package com.web_project.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Номер заказа не должен быть пустым")
    private Long orderNumber;

    @Past(message = "Дата заказа не должна быть в прошлом")
    private LocalDate orderDate;

    @NotBlank(message = "Имя клиента не должно быть пустым")
    private String customerName;

    @Email(message = "Введите корректный адрес электронной почты клиента")
    private String customerEmail;

    @Positive(message = "Сумма заказа должна быть положительной")
    private Double totalAmount;

    @Size(max = 200, message = "Комментарий не должен превышать 200 символов")
    private String comment;

    // Конструкторы, геттеры и сеттеры

    public OrderModel() {}

    public OrderModel(Long orderNumber, LocalDate orderDate, String customerName, String customerEmail, Double totalAmount, String comment) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}