package com.web_project.school.controllers;

import com.web_project.school.model.OrderModel;
import com.web_project.school.service.OrderService;
import com.web_project.school.service.StudentService; // Импортируем StudentService
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private StudentService studentService; // Добавляем StudentService

    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("students", studentService.findAll()); // Передаем список студентов для выбора
        model.addAttribute("order", new OrderModel());
        return "orderList";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result,
                           @RequestParam UUID studentId) { // Получаем ID студента из формы
        if (result.hasErrors()) {
            return "redirect:/orders/all"; // Можно добавить обработку ошибок
        }

        // Устанавливаем студента в заказ
        order.setStudent(studentService.findById(studentId));
        orderService.add(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result,
                              @RequestParam UUID studentId) {
        if (result.hasErrors()) {
            return "redirect:/orders/all";
        }

        // Устанавливаем студента в заказ при обновлении
        order.setStudent(studentService.findById(studentId));
        orderService.update(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam UUID id) {
        orderService.delete(id);
        return "redirect:/orders/all";
    }
}