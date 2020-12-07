package com.taskmanager;

public class ControllerTaskManager {
    private static ControllerTaskManager instance;
    ControllerTaskManager() {

    }
    public static ControllerTaskManager getInstance() {
        if (instance == null) {
            instance = new ControllerTaskManager();
        }
        return instance;
    }

}
