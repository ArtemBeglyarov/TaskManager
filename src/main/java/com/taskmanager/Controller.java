package com.taskmanager;

public class Controller {
    private static Controller instance;
    Controller() {

    }
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

}
