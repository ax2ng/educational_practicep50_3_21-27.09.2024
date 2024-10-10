package com.web_project.school.repository.finalpracticerepository;

import com.web_project.school.model.finalpracticemodels.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}