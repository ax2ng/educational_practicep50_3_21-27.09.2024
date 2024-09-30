package com.web_project.school.controllers;

import com.web_project.school.model.ProductModel;
import com.web_project.school.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new ProductModel());
        return "productList";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            return "productList";
        }
        productService.add(product);
        return "redirect:/products/all";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        productService.update(product);
        return "redirect:/products/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.delete(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all/{id}")
    public String getIdProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("products", productService.findById(id));
        model.addAttribute("product", new ProductModel());
        return "productList";
    }


}
