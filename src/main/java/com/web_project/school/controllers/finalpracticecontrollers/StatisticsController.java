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
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private ProjectService projectService; // Добавляем ProjectService

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all")
    public String getAllStatistics(Model model) {
        List<Statistics> statisticsList = statisticsService.findAll();
        model.addAttribute("statistics", statisticsList);
        model.addAttribute("statistic", new Statistics());
        model.addAttribute("projects", projectService.findAll()); // Передаем список проектов для выбора
        return "statisticsList"; // Шаблон для отображения списка статистики
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addStatistics(@Valid @ModelAttribute("statistic") Statistics statistic, BindingResult result) {
        if (result.hasErrors()) {
            return "statisticsList"; // Можно добавить обработку ошибок
        }

        statisticsService.add(statistic);
        return "redirect:/statistics/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateStatistics(@Valid @ModelAttribute("statistic") Statistics statistic, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/statistics/all";
        }

        statisticsService.update(statistic);
        return "redirect:/statistics/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteStatistics(@RequestParam UUID id) {
        statisticsService.delete(id);
        return "redirect:/statistics/all";
    }
}