package com.web_project.school.controllers;

import com.web_project.school.model.ProductModel;
import com.web_project.school.model.StudentModel;
import com.web_project.school.service.ProductService;
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
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StudentService studentService; // Добавляем StudentService

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("students", studentService.findAll()); // Передаем список студентов для выбора
        model.addAttribute("product", new ProductModel());
        return "productList"; // Шаблон для отображения списка продуктов
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result,
                             @RequestParam(required = false) UUID[] studentIds) { // Получаем ID студентов из формы
        if (result.hasErrors()) {
            return "redirect:/products/all"; // Можно добавить обработку ошибок
        }

        // Сохраняем продукт и устанавливаем студентов, если они выбраны
        productService.add(product);

        if (studentIds != null) {
            for (UUID studentId : studentIds) {
                StudentModel student = studentService.findById(studentId);
                student.getProducts().add(product); // Добавляем продукт к студенту
                studentService.update(student); // Обновляем студента в базе данных
            }
        }

        return "redirect:/products/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/all";
        }

        productService.update(product);
        return "redirect:/products/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam UUID id) {
        productService.delete(id);
        return "redirect:/products/all";
    }
}