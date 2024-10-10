package com.web_project.school.controllers.finalpracticecontrollers;  import com.web_project.school.model.finalpracticemodels.*; import com.web_project.school.service.finalpracticeservices.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "employeeList"; // Шаблон для отображения списка сотрудников
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeList"; // Можно добавить обработку ошибок
        }

        employeeService.add(employee);
        return "redirect:/employees/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/employees/all";
        }

        employeeService.update(employee);
        return "redirect:/employees/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam UUID id) {
        employeeService.delete(id);
        return "redirect:/employees/all";
    }
}