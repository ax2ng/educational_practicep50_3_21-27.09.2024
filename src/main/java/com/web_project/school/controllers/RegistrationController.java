package com.web_project.school.controllers;

import com.web_project.school.model.RoleEnum;
import com.web_project.school.model.UserModel;
import com.web_project.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UserModel user, Model model) {
        // Проверка на существование пользователя
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("message", "Пользователь уже существует");
            return "regis";
        }

        // Проверка на длину пароля
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            model.addAttribute("message", "Пароль должен содержать не менее 8 символов");
            return "regis";
        }

        // Проверка на наличие хотя бы одной буквы, одной цифры и одного специального символа
        if (!user.getPassword().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$")) {
            model.addAttribute("message", "Пароль должен содержать хотя бы одну букву, одну цифру и один специальный символ (@#$%^&+=!)");
            return "regis";
        }

        // Устанавливаем активность и роль пользователя
        user.setActive(true);
        user.setRoles(Collections.singleton(RoleEnum.USER));

        // Кодируем пароль и сохраняем пользователя
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login"; // Перенаправление после успешной регистрации
    }
}