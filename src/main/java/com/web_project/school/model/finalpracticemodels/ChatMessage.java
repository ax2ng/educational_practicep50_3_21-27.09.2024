package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Сообщение не может быть пустым")
    private String message;

    @NotNull(message = "Дата отправки не может быть пустой")
    private Date sentDate;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    @NotNull(message = "Чат не может быть пустым")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "Сотрудник не может быть пустым")
    private Employee employee;

    @OneToMany(mappedBy = "message")
    private List<ChatFile> files;

    public ChatMessage() {}

    public ChatMessage(UUID id, String message, Date sentDate, Chat chat, Employee employee, List<ChatFile> files) {
        this.id = id;
        this.message = message;
        this.sentDate = sentDate;
        this.chat = chat;
        this.employee = employee;
        this.files = files;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ChatFile> getFiles() {
        return files;
    }

    public void setFiles(List<ChatFile> files) {
        this.files = files;
    }
}