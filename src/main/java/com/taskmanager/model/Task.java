package com.taskmanager.model;

import com.taskmanager.ModelTaskManager;
import lombok.Getter;

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

    @Getter
    long taskID = ModelTaskManager.createID();
    private String name;

}
