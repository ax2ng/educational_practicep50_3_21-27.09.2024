package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.Status;
import com.web_project.school.repository.finalpracticerepository.StatusRepository;
import com.web_project.school.service.finalpracticeservices.StatusService;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl extends GenericServiceImpl<Status> implements StatusService {

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        super(statusRepository);
    }
}