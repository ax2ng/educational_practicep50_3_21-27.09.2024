package com.web_project.school.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не должна быть пустой")
    private String lastName;

    @Email(message = "Введите корректный адрес электронной почты")
    private String email;

    @Min(value = 18, message = "Возраст должен быть не менее 18 лет")
    @Max(value = 100, message = "Возраст не может превышать 100 лет")
    private int age;

    @NotNull(message = "Пол не должен быть пустым")
    @Pattern(regexp = "Мужской|Женский", message = "Пол должен быть 'Мужской' или 'Женский'")
    private String gender;

    @Past(message = "Дата рождения должна быть в прошлом")
    private LocalDate birthDate;

    // Конструкторы, геттеры и сеттеры

    public StudentModel() {}

    public StudentModel(String firstName, String lastName, String email, int age, String gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}