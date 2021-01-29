package com.taskmanager;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Model {

    private static Model instance;
    Repository repository = jsonLoad();
    //TODO зачем здесь он
    Scanner scanner = new Scanner(System.in);

    private Model() {
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    //TODO ограничить типы как?
    public static long createID(Class type) {

        Random random = new Random();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        while (true) {
            int randomID = random.nextInt(1000);
            long ID = Long.parseLong(date.format(formatter) + randomID);
            if (type == Project.class && !Model.getInstance().repository.projectMap.containsKey(ID)) {
                return ID;
            } else if (type == Task.class) {
                if (!Model.getInstance().repository.taskMap.containsKey(ID)) {
                    return ID;
                }
            } else if (type == User.class) {
                if (!Model.getInstance().repository.userMap.containsKey(ID)) {
                    return ID;
                }
            } else return 0;
        }
    }

    public User createUsers( String firstName, String lastName, String userName, String password) {


        User user = new User(firstName, lastName, userName, password);
        repository.addUser(user.getID(), user);
        return user;
    }
    /*public  User createUsersDefault() {
        User user = new User();
        repository.addUser(user.getID(),user);
        return user;
    }*/

    public User readUser(long ID) {
        return repository.userMap.get(ID);
    }

    public void updateUser(long ID, User user) {
        repository.userMap.replace(ID, user);
    }

    public void removeUser(long ID) {
        repository.userMap.remove(ID);
    }
    public boolean isUserExist(String userName, String password) {
         return  repository.checkUser(userName,password);
    }

    public void createTask(String name, Task.Status status, Task.Priority priority, String description,
                           Date startData, Date duoDate, Date endDate,
                           long projectId, long reporterId, long assigneeId) {
        Task task = new Task(name, status, priority, description, startData, duoDate,
                endDate, projectId, reporterId, assigneeId);
        repository.addTask(task.getID(), task);

    }

    public Task readTask(long ID) {
        return repository.taskMap.get(ID);
    }
    public void updateTask(long ID, Task task) {
        repository.taskMap.replace(ID, task);
    }

    public void deleteTask(long ID) {
        repository.taskMap.remove(ID);
    }

    public Project createProject(String nameProject, List<Long> usersID, List<Long> tasksID, String description, Long creatorID) {
        /*System.out.println("Name Project");
        String projectName = scanner.nextLine();

        System.out.println("describe the project");
        String description = scanner.nextLine();*/

        Project project = new Project(nameProject, usersID, tasksID, description, creatorID);
        repository.addProject(project.getID(), project);
        return project;
    }

    public Project readProject(long ID) {
        return repository.projectMap.get(ID);
    }

    public void updateProject(long ID, Project project) {
        repository.projectMap.replace(ID, project);
    }

    public void deleteProject(long ID) {
        repository.projectMap.remove(ID);
    }

    public static void jsonSave(Repository repository, OutputStream out) throws IOException {
        ObjectOutputStream serialize = new ObjectOutputStream(out);
        serialize.writeObject(repository);
    }

    public static Repository jsonLoad(InputStream in) throws IOException {
        Repository temp = null;
        try {
            ObjectInputStream deserialize = new ObjectInputStream(in);

            temp = (Repository) deserialize.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void jsonSave() {
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
            temp = mapper.readValue(new File("repository1.json"), Repository.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
