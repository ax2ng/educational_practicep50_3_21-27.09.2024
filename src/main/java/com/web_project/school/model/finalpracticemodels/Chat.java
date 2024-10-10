package com.web_project.school.model.finalpracticemodels;

import com.web_project.school.model.StudentModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Тип чата не может быть пустым")
    @Size(max = 20, message = "Тип чата не должен превышать 20 символов")
    private String chatType; // project или task

    @OneToOne(mappedBy = "chat")
    private Project project;

    @OneToOne(mappedBy = "chat")
    private Task task;

    @OneToMany(mappedBy = "chat")
    private List<ChatMessage> messages;

    public Chat() {}

    public Chat(UUID id, String chatType, Project project, Task task, List<ChatMessage> messages) {
        this.id = id;
        this.chatType = chatType;
        this.project = project;
        this.task = task;
        this.messages = messages;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Тип чата не может быть пустым") @Size(max = 20, message = "Тип чата не должен превышать 20 символов") String getChatType() {
        return chatType;
    }

    public void setChatType(@NotBlank(message = "Тип чата не может быть пустым") @Size(max = 20, message = "Тип чата не должен превышать 20 символов") String chatType) {
        this.chatType = chatType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}