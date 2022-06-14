package com.generation.SpringAssessment.repository.entity;

import com.generation.SpringAssessment.controller.dto.TaskDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTasks;
    private String title;
    private String description;
    private String targetDate;

    public Task(){}

    public Task(TaskDto taskDto){
        this.title = taskDto.getTitle();
        this.description = taskDto.getDescription();
        this.targetDate = taskDto.getTargetDate();
    }


    public Integer getIdTasks() {
        return idTasks;
    }

    public void setIdTasks(Integer idTasks) {
        this.idTasks = idTasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + idTasks +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                '}';
    }
} // End of Task Class
