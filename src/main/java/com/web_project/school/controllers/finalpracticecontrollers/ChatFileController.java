package com.web_project.school.controllers.finalpracticecontrollers;
import com.web_project.school.model.finalpracticemodels.*;
import com.web_project.school.service.finalpracticeservices.*;
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
@RequestMapping("/chat-files")
public class ChatFileController {

    @Autowired
    private ChatFileService chatFileService;

    @Autowired
    private ChatMessageService chatMessageService; // Добавляем ChatMessageService

    @GetMapping("/all")
    public String getAllChatFiles(Model model) {
        List<ChatFile> chatFiles = chatFileService.findAll();
        model.addAttribute("chatFiles", chatFiles);
        model.addAttribute("chatFile", new ChatFile());
        model.addAttribute("messages", chatMessageService.findAll()); // Передаем список сообщений для выбора
        return "chatFileList"; // Шаблон для отображения списка файлов чата
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addChatFile(@Valid @ModelAttribute("chatFile") ChatFile chatFile, BindingResult result) {
        if (result.hasErrors()) {
            return "chatFileList"; // Можно добавить обработку ошибок
        }

        chatFileService.add(chatFile);
        return "redirect:/chat-files/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateChatFile(@Valid @ModelAttribute("chatFile") ChatFile chatFile, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/chat-files/all";
        }

        chatFileService.update(chatFile);
        return "redirect:/chat-files/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteChatFile(@RequestParam UUID id) {
        chatFileService.delete(id);
        return "redirect:/chat-files/all";
    }
}