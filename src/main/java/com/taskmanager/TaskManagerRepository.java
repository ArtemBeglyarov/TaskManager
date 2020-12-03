package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TaskManagerRepository implements Serializable {

    Map<Long, User> userMap = new HashMap<Long, User>();
    Map<Long, Project> projectMap = new HashMap<Long,Project>();
    Map<Long, Task> taskMap = new HashMap<Long, Task>();


    public void addUserRepository(Long userID, User user){
        this.userMap.put(userID,user);
    }
    public  void getAllUsers() {
        for (User k : this.userMap.values()) {
            System.out.println(k.toString());
            System.out.println();
        }

    }
   public  void addTaskRepository() {

   }
    public void addProjectRepository() {

    }


}
