package com.web_project.school.model.finalpracticemodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "chat_files")
public class ChatFile {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Имя файла не может быть пустым")
    @Size(max = 255, message = "Имя файла не должно превышать 255 символов")
    private String fileName;

    @NotNull(message = "Содержимое файла не может быть пустым")
    private String fileContent;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private ChatMessage message;

    public ChatFile() {}

    public ChatFile(UUID id, String fileName, String fileContent, ChatMessage message) {
        this.id = id;
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Имя файла не может быть пустым") @Size(max = 255, message = "Имя файла не должно превышать 255 символов") String getFileName() {
        return fileName;
    }

    public void setFileName(@NotBlank(message = "Имя файла не может быть пустым") @Size(max = 255, message = "Имя файла не должно превышать 255 символов") String fileName) {
        this.fileName = fileName;
    }

    public @NotNull(message = "Содержимое файла не может быть пустым") String getFileContent() {
        return fileContent;
    }

    public void setFileContent(@NotNull(message = "Содержимое файла не может быть пустым") String fileContent) {
        this.fileContent = fileContent;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}