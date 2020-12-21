package com.taskmanager;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect

public class Repository implements Serializable {
    @JsonIgnore
    private static Repository instance;

    Repository() {}

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
    @JsonProperty
    final Map<Long, User> userMap = new HashMap<>();
    @JsonProperty
    final Map<Long, Project> projectMap = new HashMap<>();
    @JsonProperty
    final Map<Long, Task> taskMap = new HashMap<>();

    /**
     * Operations on objects User
     */
    public void addUser(Long id, User user) {
       userMap.put(id, user);
    }

    public User getUser(long id) {
        return userMap.get(id);
    }

    public void removeUser(long id) {
        userMap.remove(id);
    }

    public void getAllUsers() {
        for (User k : userMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }
    }

    /**
     * Operations on objects Task
     */
    public void addTask(Long id, Task task) {
        taskMap.put(id, task);
    }

    public Task getTask(long id) {
        return taskMap.get(id);
    }

    public void removeTask(long id) {
        taskMap.remove(id);
    }

    public  void getAllTask() {
        for (Task k : taskMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }
    }

    /**
     * Operations on objects Project
     */
    public void addProject(Long id, Project project) {
        projectMap.put(id, project);
    }

    public Project getProject(long id) {
        return projectMap.get(id);
    }

    public void removeProject(long id) {
        projectMap.remove(id);
    }

    public  void getAllProject() {
        for (Project k : projectMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }
    }


}
