package com.web_project.school.repository;

import com.web_project.school.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    List<StudentModel> findByFirstNameContainingIgnoreCase(String firstName);
}