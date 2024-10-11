package com.web_project.school.controllers.finalpracticecontrollers;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.model.finalpracticemodels.Employee;
import com.web_project.school.model.finalpracticemodels.Project;
import com.web_project.school.model.finalpracticemodels.Chat;
import com.web_project.school.service.finalpracticeservices.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ChatService chatService; // Добавляем ChatService


    @Autowired
    private TaskService taskService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all")
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("project", new Project());
        model.addAttribute("statuses", statusService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("chats", chatService.findAll());
        return "projectList"; // Шаблон для отображения списка проектов
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
                             @RequestParam(required = false) UUID[] employeeIds, @RequestParam String chatType, Model model) {
        // Проверка на наличие ошибок
        if (result.hasErrors()) {
            model.addAttribute("message", "Пожалуйста, исправьте ошибки в форме.");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на пустое название проекта
        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
            model.addAttribute("message", "Название проекта не может быть пустым");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на пустое описание проекта
        if (project.getProjectDescription() == null || project.getProjectDescription().isEmpty()) {
            model.addAttribute("message", "Описание проекта не может быть пустым");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на дату начала: должна быть сегодня или в будущем
        LocalDate today = LocalDate.now();
        if (project.getStartDate() == null || project.getStartDate().isBefore(today)) {
            model.addAttribute("message", "Дата начала должна быть сегодня или в будущем");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на дату окончания: должна быть позже даты начала
        if (project.getEndDate() == null || project.getEndDate().isBefore(project.getStartDate())) {
            model.addAttribute("message", "Дата окончания должна быть позже даты начала");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на статус: должен быть выбран
        if (project.getStatus() == null) {
            model.addAttribute("message", "Статус проекта должен быть выбран");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

        // Создаем профиль для студента с введенным описанием
        Chat chat = new Chat();
        chat.setChatType(chatType);

        // Устанавливаем профиль в студента
        project.setChat(chat);

        projectService.add(project);

        if (employeeIds != null) {
            for (UUID employeeId : employeeIds) {
                Employee employee = employeeService.findById(employeeId);
                employee.getProjects().add(project); // Добавляем продукт к студенту
                employeeService.update(employee); // Обновляем студента в базе данных
            }
        }


        return "redirect:/projects/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result) { // Получаем тип чата из формы

        if (result.hasErrors()) {
            return "redirect:/projects/all";
        }

        // Обновляем проект
        projectService.update(project);
        return "redirect:/projects/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteProject(@RequestParam UUID id) {
        projectService.delete(id);
        return "redirect:/projects/all";
    }
}