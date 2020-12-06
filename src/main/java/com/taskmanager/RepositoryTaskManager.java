package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RepositoryTaskManager implements Serializable {

    final Map<Long, User> userMap = new HashMap<>();
    final Map<Long, Project> projectMap = new HashMap<>();
    final Map<Long, Task> taskMap = new HashMap<>();

    public void addUserRepository(Long ID, User user) {
        this.userMap.put(ID, user);
    }

    public void getAllUsers() {
        for (User k : this.userMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }

    }

    public void addTaskRepository() {

    }

    public void addProjectRepository() {

    }


}
