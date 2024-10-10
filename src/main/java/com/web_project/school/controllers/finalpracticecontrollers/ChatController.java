package com.web_project.school.controllers.finalpracticecontrollers;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.finalpracticemodels.Chat;
import com.web_project.school.model.finalpracticemodels.Project;
import com.web_project.school.model.finalpracticemodels.Task;
import com.web_project.school.service.finalpracticeservices.ChatService;
import com.web_project.school.service.finalpracticeservices.ProjectService;
import com.web_project.school.service.finalpracticeservices.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public String getAllChats(Model model) {
        model.addAttribute("chats", chatService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("chat", new Chat());// Для выбора задачи
        return "chatList"; // Шаблон для отображения списка чатов
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addChat(@RequestParam String chatType) {
        Chat chat = new Chat();
        chat.setChatType(chatType);

        // Профиль создается без привязки к студенту (student будет NULL)
        chat.setProject(null);
        chat.setTask(null);


        // Сохраняем чат
        chatService.add(chat);
        return "redirect:/chats/all"; // Перенаправление на страницу со списком чатов
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateChat(@Valid @ModelAttribute("chat") Chat chat, @RequestParam UUID projectId, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/chats/all";
        }

        // Устанавливаем студента в профиль
        if (projectId != null) {
            chat.setProject(projectService.findById(projectId));
        } else {
            chat.setProject(null); // Если студент не выбран, оставляем NULL
        }

        chatService.update(chat);
        return "redirect:/chats/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteChat(@RequestParam UUID id) {
        chatService.delete(id);
        return "redirect:/chats/all";
    }
}