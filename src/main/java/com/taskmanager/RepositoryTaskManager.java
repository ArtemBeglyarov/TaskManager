package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RepositoryTaskManager implements Serializable {

    private static RepositoryTaskManager instance;

    private RepositoryTaskManager() {
    }
    public static RepositoryTaskManager getInstance() {
        if (instance == null) {
            instance = new RepositoryTaskManager();
        }
        return instance;
    }

    static final Map<Long, User> userMap = new HashMap<>();
    static final Map<Long, Project> projectMap = new HashMap<>();
    static final Map<Long, Task> taskMap = new HashMap<>();

    public static void addUserRepository(Long ID, User user) {
        userMap.put(ID, user);
    }

    public static void getAllUsers() {
        for (User k : userMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }
    }

    public void addTaskRepository() {

    }

    public void addProjectRepository() {

    }


}
