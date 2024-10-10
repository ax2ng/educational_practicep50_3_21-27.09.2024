package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.Project;
import com.web_project.school.model.finalpracticemodels.Statistics;
import com.web_project.school.model.finalpracticemodels.Status;
import com.web_project.school.repository.finalpracticerepository.ProjectRepository;
import com.web_project.school.service.finalpracticeservices.ProjectService;
import com.web_project.school.service.finalpracticeservices.StatisticsService;
import com.web_project.school.service.finalpracticeservices.StatusService;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project> implements ProjectService {

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        super(projectRepository);
    }
}