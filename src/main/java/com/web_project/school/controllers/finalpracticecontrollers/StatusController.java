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
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private ProjectService projectService; // Добавляем ProjectService

    @Autowired
    private TaskService taskService; // Добавляем TaskService

    @GetMapping("/all")
    public String getAllStatuses(Model model) {
        List<Status> statuses = statusService.findAll();
        model.addAttribute("statuses", statuses);
        model.addAttribute("status", new Status());
        return "statusList"; // Шаблон для отображения списка статусов
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addStatus(@Valid @ModelAttribute("status") Status status, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/statuses/all"; // Можно добавить обработку ошибок
        }

        statusService.add(status);
        return "redirect:/statuses/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateStatus(@Valid @ModelAttribute("status") Status status, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/statuses/all";
        }

        statusService.update(status);
        return "redirect:/statuses/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteStatus(@RequestParam UUID id) {
        statusService.delete(id);
        return "redirect:/statuses/all";
    }
}