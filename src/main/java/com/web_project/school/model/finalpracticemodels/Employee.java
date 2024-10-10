package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Логин не может быть пустым")
    @Size(max = 50, message = "Логин не должен превышать 50 символов")
    private String login;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Email должен быть корректным")
    private String email;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    private String middleName;

    @Size(max = 15, message = "Номер телефона не должен превышать 15 символов")
    private String phoneNumber;

    private LocalDate birthDate;

    private String avatar;

    private String position;

    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Employee() {}

    public Employee(UUID id, String login, String password, String email, String firstName, String lastName, String middleName, String phoneNumber, LocalDate birthDate, String avatar, String position, List<Project> projects) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.avatar = avatar;
        this.position = position;
        this.projects = projects;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Логин не может быть пустым") @Size(max = 50, message = "Логин не должен превышать 50 символов") String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank(message = "Логин не может быть пустым") @Size(max = 50, message = "Логин не должен превышать 50 символов") String login) {
        this.login = login;
    }

    public @NotBlank(message = "Пароль не может быть пустым") @Size(min = 6, message = "Пароль должен содержать минимум 6 символов") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Пароль не может быть пустым") @Size(min = 6, message = "Пароль должен содержать минимум 6 символов") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Email не может быть пустым") @Email(message = "Email должен быть корректным") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email не может быть пустым") @Email(message = "Email должен быть корректным") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Имя не может быть пустым") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Имя не может быть пустым") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Фамилия не может быть пустой") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Фамилия не может быть пустой") String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public @Size(max = 15, message = "Номер телефона не должен превышать 15 символов") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(max = 15, message = "Номер телефона не должен превышать 15 символов") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}