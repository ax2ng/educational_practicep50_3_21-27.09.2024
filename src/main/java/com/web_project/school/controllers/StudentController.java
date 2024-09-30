package com.web_project.school.controllers;

import com.web_project.school.model.StudentModel;
import com.web_project.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.findAll());
            return "studentList";
        }
        studentService.add(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result) {
        studentService.update(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.delete(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("firstName") String firstName, Model model) {
        List<StudentModel> students = studentService.findByName(firstName);
        model.addAttribute("students", students);
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }
}



