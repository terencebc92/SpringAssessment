package com.generation.SpringAssessment.service;

import com.generation.SpringAssessment.repository.TaskRepository;
import com.generation.SpringAssessment.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceMySQL implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceMySQL(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> all() {
        List<Task> result = new ArrayList<>();
        taskRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(int taskId) {
        taskRepository.deleteById(taskId);
    }
//
//    @Override
//    public Task findById(int taskId) {
//        Optional<Task> task = taskRepository.findById(taskId);
//        Task taskResponse = task.get();
//        return taskResponse;
//    }

} // End of TaskServiceMySQL Class
