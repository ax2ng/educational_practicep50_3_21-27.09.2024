package com.web_project.school.service.impl;

import com.web_project.school.model.StudentModel;
import com.web_project.school.repository.StudentRepository; // Убедитесь, что этот репозиторий существует.
import com.web_project.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends GenericServiceImpl<StudentModel> implements StudentService {

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
    }
}