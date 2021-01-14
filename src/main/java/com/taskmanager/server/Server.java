package com.taskmanager.server;

import com.taskmanager.Controller;
import com.taskmanager.Model;
import com.taskmanager.Repository;
import com.taskmanager.model.User;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        Model model = Model.getInstance();
        Controller controller = Controller.getInstance();
        Repository repository = model.jsonLoad();



            ServerSocket serverSocket = new ServerSocket(9900);
        try {


            while (true) {
                Socket socket = serverSocket.accept();
                new ThreadServer(socket,model,controller,repository);
                model.jsonSave(repository);
            }
        } catch (IOException e) {
          e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }

    }
}

class ThreadServer extends Thread {
    Model model;
    Controller controller;
    Repository repository;
    Socket socket;

    public ThreadServer(Socket socket,Model model, Controller controller, Repository repository) {
        this.socket = socket;
        this.model = model;
        this.repository  = repository;
        this.controller = controller;
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writ = new PrintWriter (new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                writ.println(" input :sing in or sing up");
                String str  = read.readLine();
                switch (str) {

                    case "sing in":
                        writ.println("");
                        if (repository.getUser()


                    case "sing up":
                        writ.println("Enter your first name");
                        String firstName = read.readLine();
                                writ.println("Enter your last name");
                        String lastName = read.readLine();
                                writ.println("create a user name");
                        String userName = read.readLine();
                                writ.println("create a password");
                        String password = read.readLine();

                        User idUser = model.createUsers(firstName,lastName,userName,password);;
                        writ.println(idUser.getID() + " your ID ");
                        writ.println("pleas sing in");

                        break;
                    case "exit":
                        writ.println("your exit");
                        System.out.println("User left the server");
                        break;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}