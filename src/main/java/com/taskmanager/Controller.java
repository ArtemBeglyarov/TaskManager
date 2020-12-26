package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;

public class Controller {
    private static Controller instance;
    Model model;

    Controller(Model model) {
        this.model = model;
    }

    public static Controller getInstance(Model model) {
        if (instance == null) {
            instance = new Controller(model);
        }
        return instance;
    }

}
