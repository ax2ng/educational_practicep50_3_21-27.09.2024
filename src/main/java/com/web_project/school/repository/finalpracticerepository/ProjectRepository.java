package com.web_project.school.repository.finalpracticerepository;

import com.web_project.school.model.StudentModel;
import com.web_project.school.model.finalpracticemodels.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}