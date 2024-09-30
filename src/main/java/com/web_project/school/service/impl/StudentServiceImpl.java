package com.web_project.school.service.impl;

import com.web_project.school.model.StudentModel;
import com.web_project.school.repository.StudentRepository; // Убедитесь, что этот репозиторий существует.
import com.web_project.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends GenericServiceImpl<StudentModel> implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findByName(String firstName) { // Реализация метода поиска
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName); // Измените на firstName
    }
}