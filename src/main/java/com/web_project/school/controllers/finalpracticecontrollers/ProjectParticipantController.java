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
//@RequestMapping("/project-participants")
//public class ProjectParticipantController {
//
//    @Autowired
//    private ProjectParticipantService projectParticipantService;
//
//    @Autowired
//    private ProjectService projectService; // Добавляем ProjectService
//
//    @Autowired
//    private EmployeeService employeeService; // Добавляем EmployeeService
//
//    @GetMapping("/all")
//    public String getAllProjectParticipants(Model model) {
//        List<ProjectParticipant> participants = projectParticipantService.findAll();
//        model.addAttribute("participants", participants);
//        model.addAttribute("participant", new ProjectParticipant());
//        model.addAttribute("projects", projectService.findAll()); // Передаем список проектов для выбора
//        model.addAttribute("employees", employeeService.findAll()); // Передаем список сотрудников для выбора
//        return "projectParticipantList"; // Шаблон для отображения списка участников проекта
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
//    @PostMapping("/add")
//    public String addProjectParticipant(@Valid @ModelAttribute("participant") ProjectParticipant participant, BindingResult result) {
//        if (result.hasErrors()) {
//            return "projectParticipantList"; // Можно добавить обработку ошибок
//        }
//
//        projectParticipantService.add(participant);
//        return "redirect:/project-participants/all";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
//    @PostMapping("/update")
//    public String updateProjectParticipant(@Valid @ModelAttribute("participant") ProjectParticipant participant, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/project-participants/all";
//        }
//
//        projectParticipantService.update(participant);
//        return "redirect:/project-participants/all";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PostMapping("/delete")
//    public String deleteProjectParticipant(@RequestParam UUID id) {
//        projectParticipantService.delete(id);
//        return "redirect:/project-participants/all";
//    }
//}