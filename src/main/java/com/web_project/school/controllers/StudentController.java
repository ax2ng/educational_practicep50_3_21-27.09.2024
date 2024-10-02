package com.web_project.school.controllers;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.ProfileService;
import com.web_project.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfileService profileService; // Добавляем ProfileService

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("student", new StudentModel()); // Новый экземпляр студента
        model.addAttribute("profiles", profileService.findAll()); // Добавляем список профилей для выбора
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result,
                             @RequestParam String bio, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.findAll());
            model.addAttribute("profiles", profileService.findAll());
            return "studentList";
        }

        // Создаем профиль для студента с введенным описанием
        ProfileModel profile = new ProfileModel();
        profile.setBio(bio);

        // Устанавливаем профиль в студента
        student.setProfile(profile);

        // Сохраняем студента (профиль будет сохранен автоматически из-за CascadeType.ALL)
        studentService.add(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result,
                                @RequestParam UUID profileId) {
        if (result.hasErrors()) {
            return "redirect:/students/all"; // Можно добавить обработку ошибок
        }

        // Получаем профиль по ID и устанавливаем его в студента
        ProfileModel profile = profileService.findById(profileId);
        student.setProfile(profile);

        studentService.update(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam UUID id) {
        studentService.delete(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

}



