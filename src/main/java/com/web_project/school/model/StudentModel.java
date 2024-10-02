package com.web_project.school.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;


    // Связь многие ко многим с ProductModel через промежуточную таблицу
    @ManyToMany
    @JoinTable(
            name = "student_products",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductModel> products;

    // Связь один ко многим с OrderModel (студент может иметь много заказов)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    // Связь один к одному с ProfileModel
    @OneToOne(cascade = CascadeType.ALL) // При удалении студента удаляется и профиль
    @JoinColumn(name = "profile_id") // Внешний ключ для связи с ProfileModel
    private ProfileModel profile;

    public StudentModel() {}

    public StudentModel(UUID id, String firstName, String lastName, List<ProductModel> products, List<OrderModel> orders, ProfileModel profile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = products;
        this.orders = orders;
        this.profile = profile;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }

    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }
}