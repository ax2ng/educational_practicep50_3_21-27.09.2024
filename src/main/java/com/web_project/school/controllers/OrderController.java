package com.web_project.school.controllers;

import com.web_project.school.model.OrderModel;
import com.web_project.school.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("order", new OrderModel());
        return "orderList";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.findAll());
            return "orderList";
        }
        orderService.add(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result) {
        orderService.update(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long id) {
        orderService.delete(id);
        return "redirect:/orders/all";
    }

    @GetMapping("/all/{id}")
    public String getIdOrder(@PathVariable("id") Long id, Model model) {
        model.addAttribute("orders", orderService.findById(id));
        model.addAttribute("order", new OrderModel());
        return "orderList";
    }


}
