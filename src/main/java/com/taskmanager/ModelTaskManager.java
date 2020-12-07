package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;



public class ModelTaskManager {

    private static ModelTaskManager instance;
    ModelTaskManager(){}

    public static ModelTaskManager getInstance() {
        if (instance == null) {
            instance = new ModelTaskManager();
        }
        return instance;
    }

    Scanner scanner = new Scanner(System.in);

    RepositoryTaskManager repository = new RepositoryTaskManager();

    public static long createID() {

        Random random = new Random();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        int randomID = random.nextInt(1000);
        long ID = Long.parseLong(date.format(formatter) + randomID);
        return ID;
    }

    public  User createUsers() {

        System.out.println("you First Name");
        String firstName = scanner.nextLine();

        System.out.println("you Last Name");
        String lastName = scanner.nextLine();

        System.out.println("User Name");
        String userName = scanner.nextLine();

        System.out.println("Password");
        String password = scanner.nextLine();

        User user = new User(firstName,lastName,userName,password);

        repository.addUser(user.getID(),user);


        return user;
    }
    public  User createUsersDefault() {
        User user = new User();
        repository.addUser(user.getID(),user);
        return user;
    }
    public Project createProject() {
        System.out.println("Name Project");
        String projectName = scanner.nextLine();

        System.out.println("describe the project");
        String description = scanner.nextLine();

        Project project = new Project();
        repository.addProject(project.getID(),project);
        return project;
    }

}
