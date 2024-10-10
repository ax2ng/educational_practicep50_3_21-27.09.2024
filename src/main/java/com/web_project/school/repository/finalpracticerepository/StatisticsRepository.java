package com.web_project.school.repository.finalpracticerepository;

import com.web_project.school.model.StudentModel;
import com.web_project.school.model.finalpracticemodels.Statistics;
import com.web_project.school.model.finalpracticemodels.Status;
import com.web_project.school.model.finalpracticemodels.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {
}