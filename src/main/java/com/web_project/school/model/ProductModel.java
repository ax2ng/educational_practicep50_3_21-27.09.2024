package com.web_project.school.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название продукта не должно быть пустым")
    private String name;

    @NotNull(message = "Цена не должна быть пустой")
    @DecimalMin(value = "0.01", message = "Цена должна быть положительной")
    private Double price;

    @Min(value = 0, message = "Количество не может быть отрицательным")
    private int quantity;

    @NotBlank(message = "Описание продукта не должно быть пустым")
    @Size(max = 500, message = "Описание не должно превышать 500 символов")
    private String description;

    @Pattern(regexp = "Доступен|Недоступен", message = "Статус должен быть 'Доступен' или 'Недоступен'")
    private String status;

    @Future(message = "Дата окончания акции должна быть в будущем")
    private LocalDate promotionEndDate;


    public ProductModel() {}

    public ProductModel(String name, Double price, int quantity, String description, String status, LocalDate promotionEndDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.promotionEndDate = promotionEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(LocalDate promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }
}