package com.taskmanager.model;

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
    int ID;
    private String name;

}
