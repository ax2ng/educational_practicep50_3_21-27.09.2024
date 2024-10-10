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
@RequestMapping("/milestones")
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @Autowired
    private ProjectService projectService; // Добавляем ProjectService

    @GetMapping("/all")
    public String getAllMilestones(Model model) {
        List<Milestone> milestones = milestoneService.findAll();
        model.addAttribute("milestones", milestones);
        model.addAttribute("milestone", new Milestone());
        model.addAttribute("projects", projectService.findAll()); // Передаем список проектов для выбора
        return "milestoneList"; // Шаблон для отображения списка этапов
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addMilestone(@Valid @ModelAttribute("milestone") Milestone milestone, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/milestones/all"; // Можно добавить обработку ошибок
        }

        milestoneService.add(milestone);
        return "redirect:/milestones/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateMilestone(@Valid @ModelAttribute("milestone") Milestone milestone, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/milestones/all";
        }

        milestoneService.update(milestone);
        return "redirect:/milestones/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteMilestone(@RequestParam UUID id) {
        milestoneService.delete(id);
        return "redirect:/milestones/all";
    }
}