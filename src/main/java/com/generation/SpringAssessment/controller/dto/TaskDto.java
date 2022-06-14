package com.generation.SpringAssessment.controller.dto;

public class TaskDto {

    private String title;
    private String description;
    private String targetDate;

    public TaskDto(String title, String description, String targetDate) {
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
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


} // End of TaskDto Class
