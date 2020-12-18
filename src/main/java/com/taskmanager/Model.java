package com.taskmanager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskmanager.model.Project;
import com.taskmanager.model.User;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;



public class Model implements Serializable{

    private static Model instance;
    Repository repositoryTask = new Repository();
    Scanner scanner = new Scanner(System.in);

    Model(){}

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
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

        repositoryTask.addUser(user.getID(),user);


        return user;
    }
    public  User createUsersDefault() {
        User user = new User();
        repositoryTask.addUser(user.getID(),user);
        return user;
    }
    public Project createProject() {
        System.out.println("Name Project");
        String projectName = scanner.nextLine();

        System.out.println("describe the project");
        String description = scanner.nextLine();

        Project project = new Project();
        repositoryTask.addProject(project.getID(),project);
        return project;
    }
    public static void serializeRepository(Repository repository, OutputStream out) throws IOException {
        ObjectOutputStream serialize = new ObjectOutputStream(out);
        serialize.writeObject(repository);
    }

    public static Repository deserializeRepository(InputStream in) throws IOException {
        Repository temp = null;
        try {
        ObjectInputStream deserialize = new ObjectInputStream(in);

            temp = (Repository) deserialize.readObject();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public  void jsonSave(Repository repository) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("repository1.json"),repository);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Repository jsonLoad() {
        Repository temp = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            temp = mapper.readValue(new File("C:\\Users\\BeglyarovAM\\Documents\\GitHub\\TaskManager\\repository1.json"), Repository.class);
            System.out.println();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
