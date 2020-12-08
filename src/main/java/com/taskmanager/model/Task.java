package com.taskmanager.model;

import com.taskmanager.ModelTaskManager;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Task implements Serializable {
    public enum Priority implements Serializable{
        HIGHEST,
        HIGH,
        NORMAL,
        LOW,
    }

    public enum Status implements Serializable {
        OPEN,
        SUSPENDED,
        ASSIGNED,
        DISCUSSION,
        CLOSED,

    }

    private final long ID;

    private String name;

    private Status status;

    private Priority priority;

    private User creator;

    private String description;

    private Date startData;

    private Date duoDate;

    private Date endDate;

    private Project project;
    //private User Reporter;
   // private User Assignee;


    public Task(String name, Status status, Priority priority, User creator, String description, Date startData, Date duoDate, Date endDate, Project project) {
        this.ID = ModelTaskManager.createID();
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
        ID = ModelTaskManager.createID();
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
