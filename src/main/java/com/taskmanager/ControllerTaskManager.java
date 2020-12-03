package com.taskmanager;

import com.taskmanager.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Random;
import java.util.Scanner;

public class ControllerTaskManager {

    TaskManagerRepository taskManagerRepository = new TaskManagerRepository();

    public static long toCreateID() {

        Random random = new Random();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        int randomID = random.nextInt(1000);
        long ID = Long.parseLong(date.format(formatter) + randomID);
        return ID;
    }

    public  User createUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("you First Name");
        String firstName = scanner.nextLine();

        System.out.println("you Last Name");
        String lastName = scanner.nextLine();

        System.out.println("User Name");
        String userName = scanner.nextLine();

        System.out.println("Password");
        String password = scanner.nextLine();

        User user = new User(firstName,lastName,userName,password);

        this.taskManagerRepository.addUserRepository(user.getUserID(),user);


        return user;
    }
    public  User createUsersDefault() {
        User user = new User();
        this.taskManagerRepository.addUserRepository(user.getUserID(),user);
        return user;
    }
}
