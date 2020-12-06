package com.taskmanager.model;

import com.taskmanager.ModelTaskManager;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Task {
    public enum Priority {
        HIGHEST,
        HIGH,
        NORMAL,
        LOW,
    }

    public enum Status {
        OPEN,
        SUSPENDED,
        ASSIGNED,
        DISCUSSION,
        CLOSED,

    }
    @Setter
    @Getter
    long taskID = ModelTaskManager.createID();
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Status status;
    @Setter
    @Getter
    private Priority priority;
    @Setter
    @Getter
    private User creator;
    @Setter
    @Getter
    private String description;
    @Setter
    @Getter
    private Date startData;
    @Setter
    @Getter
    private Date duoDate;
    @Setter
    @Getter
    private Date endDate;
    @Setter
    @Getter
    private Project project;
    //private User Reporter;
   // private User Assignee;


    public Task(long taskID, String name, Status status, Priority priority, User creator, String description, Date startData, Date duoDate, Date endDate, Project project) {
        this.taskID = ModelTaskManager.createID();
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.creator = creator;
        this.description = description;
        this.startData = startData;
        this.duoDate = duoDate;
        this.endDate = endDate;
        this.project = project;
    }

    public Task() {
        taskID = ModelTaskManager.createID();
        name = "default";
        status = Status.OPEN;
        priority = Priority.LOW;
        creator = new User();
        description = "default";
        startData = new Date();
        duoDate = new Date();
        endDate = new Date();
        project = new Project();
    }
}
