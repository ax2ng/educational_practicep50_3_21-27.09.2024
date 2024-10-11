package com.web_project.school.controllers.finalpracticecontrollers;  import com.web_project.school.model.finalpracticemodels.*; import com.web_project.school.service.finalpracticeservices.*;
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
@RequestMapping("/chat-messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private ChatService chatService; // Добавляем ChatService

    @Autowired
    private EmployeeService employeeService; // Добавляем EmployeeService

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping("/all")
    public String getAllChatMessages(Model model) {
//        List<ChatMessage> chatMessages = chatMessageService.findAll();
        model.addAttribute("chatMessages", chatMessageService.findAll());
        model.addAttribute("chats", chatService.findAll()); // Передаем список чатов для выбора
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("chatMessage", new ChatMessage());// Передаем список сотрудников для выбора
        return "chatMessageList"; // Шаблон для отображения списка сообщений чата
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addChatMessage(@Valid @ModelAttribute("chatMessage") ChatMessage chatMessage, BindingResult result) {
        if (result.hasErrors()) {
            return "chatMessageList"; // Можно добавить обработку ошибок
        }

        chatMessageService.add(chatMessage);
        return "redirect:/chat-messages/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateChatMessage(@Valid @ModelAttribute("chatMessage") ChatMessage chatMessage, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/chat-messages/all";
        }

        chatMessageService.update(chatMessage);
        return "redirect:/chat-messages/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteChatMessage(@RequestParam UUID id) {
        chatMessageService.delete(id);
        return "redirect:/chat-messages/all";
    }
}