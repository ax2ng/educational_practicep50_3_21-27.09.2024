package com.web_project.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Ксения");
        return "homePage";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model){
        double result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/calculator")
    public String calculator(Model model){
        return "calculator";
    }
}
