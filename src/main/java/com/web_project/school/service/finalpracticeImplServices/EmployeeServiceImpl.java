package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.*;
import com.web_project.school.repository.finalpracticerepository.EmployeeRepository;
import com.web_project.school.service.finalpracticeservices.*;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService {

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }
}