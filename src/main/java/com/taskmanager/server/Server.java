package com.taskmanager.server;

import com.taskmanager.Controller;
import com.taskmanager.Model;
import com.taskmanager.Repository;

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
            }
        } catch (IOException e) {
          e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }
        model.jsonSave(repository);
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
                writ.println("Sing in or Sing up");
                String str  = read.readLine();
                switch (str) {

                    case "Sing in":
                        break;

                    case "Sing up":
                        writ.println("Enter your first name");
                        String firstName = read.readLine();
                                writ.println("Enter your last name");
                        String lastName = read.readLine();
                                writ.println("create a user name");
                        String userName = read.readLine();
                                writ.println("create a password");
                        String password = read.readLine();

                        model.createUsers(firstName,lastName,userName,password);

                        break;
                    case "exit":
                        writ.println("выход");
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