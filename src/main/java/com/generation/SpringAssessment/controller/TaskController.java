package com.generation.SpringAssessment.controller;

import com.generation.SpringAssessment.service.TaskService;
import com.generation.SpringAssessment.controller.dto.TaskDto;
import com.generation.SpringAssessment.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/task")
public class TaskController {

    final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService){
        this.taskService = taskService;
    }

    // API endpoint for GET HTTP requests
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Task> getTasks(){
        return taskService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save (
            @RequestParam(name="title", required = true) String title,
            @RequestParam(name="description", required = true) String description,
            @RequestParam(name="targetDate", required = true) String targetDate) throws IOException {

        TaskDto taskDto = new TaskDto(title, description, targetDate);
        taskService.save(new Task(taskDto));
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        taskService.delete( id );
    }



} // End of TaskController Class
