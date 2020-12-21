package com.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.taskmanager.Model;
import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonView
public class Project implements Serializable  {
    @JsonProperty("id")
    private final long ID;

    private String nameProject;

    private List<User> users;

    private List<Task> tasks;

    private String description;

    private User creator;


    public Project() {
        this.ID = Model.createID();
        this.nameProject = "default";
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.description = "default";
        this.creator = new User();
    }

    public Project(String nameProject, List<User> users, List<Task> tasks, String description, User creator) {
        this.ID = Model.createID();
        this.nameProject = nameProject;
        this.users = users;
        this.tasks = tasks;
        this.description = description;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return
                "projectID=" + ID +
                        ", nameProject='" + nameProject + '\'' +
                        ", users=" + users +
                        ", tasks=" + tasks +
                        ", description='" + description + '\'' +
                        ", creator=" + creator;

    }
}
