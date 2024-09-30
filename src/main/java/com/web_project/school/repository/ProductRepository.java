package com.web_project.school.repository;

import com.web_project.school.model.ProductModel;
import com.web_project.school.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
