package com.web_project.school.controllers.finalpracticecontrollers;  import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.finalpracticemodels.*; import com.web_project.school.service.finalpracticeservices.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService; // Добавляем ProjectService

    @Autowired
    private StatusService statusService; // Добавляем StatusService

    @Autowired
    private ChatService chatService; // Добавляем ChatService

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.findAll()); // Передаем список проектов для выбора
        model.addAttribute("statuses", statusService.findAll()); // Передаем список статусов для выбора
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("chats", chatService.findAll());
        return "taskList"; // Шаблон для отображения списка задач
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @RequestParam(required = false) UUID[] employeeIds, @RequestParam String chatType, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Пожалуйста, исправьте ошибки в форме.");
            return "projectList"; // Возврат к шаблону с ошибкой
        }

// Проверка на пустое название проекта
        if (task.getTaskName() == null || task.getTaskName().isEmpty()) {
            model.addAttribute("message", "Название проекта не может быть пустым");
            return "taskList"; // Возврат к шаблону с ошибкой
        }

// Проверка на пустое описание проекта
        if (task.getTaskDescription() == null || task.getTaskDescription().isEmpty()) {
            model.addAttribute("message", "Описание проекта не может быть пустым");
            return "taskList"; // Возврат к шаблону с ошибкой
        }

// Проверка на дату начала: должна быть сегодня или в будущем
        LocalDate today = LocalDate.now();
        if (task.getStartDate() == null || task.getStartDate().isBefore(today)) {
            model.addAttribute("message", "Дата начала должна быть сегодня или в будущем");
            return "taskList"; // Возврат к шаблону с ошибкой
        }

// Проверка на дату окончания: должна быть позже даты начала
        if (task.getEndDate() == null || task.getEndDate().isBefore(task.getStartDate())) {
            model.addAttribute("message", "Дата окончания должна быть позже даты начала");
            return "taskList"; // Возврат к шаблону с ошибкой
        }

// Проверка на статус: должен быть выбран
        if (task.getStatus() == null) {
            model.addAttribute("message", "Статус проекта должен быть выбран");
            return "taskList"; // Возврат к шаблону с ошибкой
        }

        // Создаем профиль для студента с введенным описанием
        Chat chat = new Chat();
        chat.setChatType(chatType);

        // Устанавливаем профиль в студента
        task.setChat(chat);

        taskService.add(task);

//        if (employeeIds != null) {
//            for (UUID employeeId : employeeIds) {
//                Employee employee = employeeService.findById(employeeId);
//                employee.ge().add(task); // Добавляем продукт к студенту
//                employeeService.update(employee); // Обновляем студента в базе данных
//            }
//        }
        return "redirect:/tasks/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/tasks/all";
        }

        taskService.update(task);
        return "redirect:/tasks/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteTask(@RequestParam UUID id) {
        taskService.delete(id);
        return "redirect:/tasks/all";
    }
}