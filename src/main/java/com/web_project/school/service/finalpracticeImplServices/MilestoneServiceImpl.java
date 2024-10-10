package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.*;
import com.web_project.school.repository.finalpracticerepository.MilestoneRepository;
import com.web_project.school.service.finalpracticeservices.*;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImpl extends GenericServiceImpl<Milestone> implements MilestoneService {

    @Autowired
    public MilestoneServiceImpl(MilestoneRepository milestoneRepository) {
        super(milestoneRepository);
    }
}