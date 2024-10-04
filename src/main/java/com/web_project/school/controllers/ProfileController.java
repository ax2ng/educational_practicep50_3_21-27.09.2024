package com.web_project.school.controllers;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.service.ProfileService;
import com.web_project.school.service.StudentService; // Импортируем StudentService
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private StudentService studentService; // Добавляем StudentService

    @GetMapping("/all")
    public String getAllProfiles(Model model) {
        model.addAttribute("profiles", profileService.findAll());
        model.addAttribute("students", studentService.findAll()); // Передаем список студентов
        model.addAttribute("profile", new ProfileModel());
        return "profileList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addProfile(@RequestParam String bio) {
        ProfileModel profile = new ProfileModel();
        profile.setBio(bio);

        // Профиль создается без привязки к студенту (student будет NULL)
        profile.setStudent(null);

        profileService.add(profile);
        return "redirect:/profiles/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateProfile(@Valid @ModelAttribute("profile") ProfileModel profile,
                                @RequestParam UUID studentId, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/profiles/all"; // Можно добавить обработку ошибок
        }

        // Устанавливаем студента в профиль
        if (studentId != null) {
            profile.setStudent(studentService.findById(studentId));
        } else {
            profile.setStudent(null); // Если студент не выбран, оставляем NULL
        }

        profileService.update(profile);
        return "redirect:/profiles/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteProfile(@RequestParam UUID id) {
        profileService.delete(id);
        return "redirect:/profiles/all";
    }
}