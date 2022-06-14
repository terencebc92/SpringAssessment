package com.generation.SpringAssessment.repository;

import com.generation.SpringAssessment.repository.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
