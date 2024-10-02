package com.web_project.school.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double price;

    // Связь многие ко многим с StudentModel через промежуточную таблицу
    @ManyToMany(mappedBy = "products") // Указываем, что эта связь управляется StudentModel
    private List<StudentModel> students; // Список студентов, которые имеют этот продукт

    public ProductModel() {}

    public ProductModel(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }
}