package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.Task;
import com.web_project.school.repository.finalpracticerepository.TaskRepository;
import com.web_project.school.service.finalpracticeservices.TaskService;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task> implements TaskService {

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        super(taskRepository);
    }
}