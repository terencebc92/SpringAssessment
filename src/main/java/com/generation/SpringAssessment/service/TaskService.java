package com.generation.SpringAssessment.service;

import com.generation.SpringAssessment.repository.entity.Task;
import java.util.List;

public interface TaskService {

    List<Task> all();

    Task save(Task task); // This method is used for both adding and editing

    void delete(int taskId);

} // End of TaskService Interface
