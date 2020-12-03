package com.taskmanager.model;

import com.taskmanager.ControllerTaskManager;
import lombok.Getter;

public class Task {
    public enum TaskPriority {
        HIGHEST,
        HIGH,
        NORMAL,
        LOW,
    }

    public enum TaskStatus {
        OPEN,
        SUSPENDED,
        ASSIGNED,
        DISCUSSION,
        CLOSED,

    }

    @Getter
    long taskID = ControllerTaskManager.toCreateID();
    private String name;

}
