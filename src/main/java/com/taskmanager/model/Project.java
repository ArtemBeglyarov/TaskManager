package com.taskmanager.model;

import com.taskmanager.ModelTaskManager;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Project {
    @Setter
    @Getter
    private long projectID;
    @Getter
    @Setter
    private String nameProject;
    @Getter
    @Setter
    private List<User> users;
    @Getter
    @Setter
    private List<Task> tasks;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private User creator;


    public Project( ){
        projectID = ModelTaskManager.toCreateID();
        nameProject = "default";
        users = new ArrayList<>();
        tasks = new ArrayList<>();
        description = "default";
        creator = new User();
    }

    public Project(long projectID, String nameProject, List<User> users, List<Task> tasks, String description, User creator) {
        this.projectID = projectID;
        this.nameProject = nameProject;
        this.users = users;
        this.tasks = tasks;
        this.description = description;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return
                    "projectID=" + projectID +
                    ", nameProject='" + nameProject + '\'' +
                    ", users=" + users +
                    ", tasks=" + tasks +
                    ", description='" + description + '\'' +
                    ", creator=" + creator ;

    }
}
