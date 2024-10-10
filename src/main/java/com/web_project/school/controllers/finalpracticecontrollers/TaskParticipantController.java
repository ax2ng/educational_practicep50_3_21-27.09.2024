//package com.web_project.school.controllers.finalpracticecontrollers;  import com.web_project.school.model.finalpracticemodels.*; import com.web_project.school.service.finalpracticeservices.*;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/task-participants")
//public class TaskParticipantController {
//
//    @Autowired
//    private TaskParticipantService taskParticipantService;
//
//    @Autowired
//    private TaskService taskService; // Добавляем TaskService
//
//    @Autowired
//    private EmployeeService employeeService; // Добавляем EmployeeService
//
//    @GetMapping("/all")
//    public String getAllTaskParticipants(Model model) {
//        List<TaskParticipant> participants = taskParticipantService.findAll();
//        model.addAttribute("participants", participants);
//        model.addAttribute("participant", new TaskParticipant());
//        model.addAttribute("tasks", taskService.findAll()); // Передаем список задач для выбора
//        model.addAttribute("employees", employeeService.findAll()); // Передаем список сотрудников для выбора
//        return "taskParticipantList"; // Шаблон для отображения списка участников задачи
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
//    @PostMapping("/add")
//    public String addTaskParticipant(@Valid @ModelAttribute("participant") TaskParticipant participant, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/task-participants/all"; // Можно добавить обработку ошибок
//        }
//
//        taskParticipantService.add(participant);
//        return "redirect:/task-participants/all";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
//    @PostMapping("/update")
//    public String updateTaskParticipant(@Valid @ModelAttribute("participant") TaskParticipant participant, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/task-participants/all";
//        }
//
//        taskParticipantService.update(participant);
//        return "redirect:/task-participants/all";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PostMapping("/delete")
//    public String deleteTaskParticipant(@RequestParam UUID id) {
//        taskParticipantService.delete(id);
//        return "redirect:/task-participants/all";
//    }
//}