package com.taskmanager.server;

import com.taskmanager.Controller;
import com.taskmanager.Model;
import com.taskmanager.server.funcion.ClientThreadFunctions;
import com.taskmanager.server.funcion.CreateUser;
import com.taskmanager.server.funcion.RemoveUser;
import com.taskmanager.server.funcion.UserInformation;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class Server {


    public static void main(String[] args) throws IOException {
        Controller controller = Controller.getInstance();
        Model model = Model.getInstance();


        ServerSocket serverSocket = new ServerSocket(9990);
        Map<String, ClientThreadFunctions> allFunctions = new HashMap<>();


        allFunctions.put("sing up", new CreateUser());
        allFunctions.put("remove", new RemoveUser());
        allFunctions.put("info", new UserInformation());

        try {

            while (true) {
                Socket socket = serverSocket.accept();
                new ThreadServer(socket, model, controller, allFunctions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }

    }

}

class ThreadServer extends Thread {


    Map<String, ClientThreadFunctions> allFunctions;
    Model model;
    Controller controller;
    Socket socket;
    private boolean authorization = false;

    public ThreadServer(Socket socket, Model model, Controller controller, Map<String, ClientThreadFunctions> allFunctions) {
        this.allFunctions = allFunctions;
        this.socket = socket;
        this.model = model;
        this.controller = controller;
        start();
    }

    public boolean authorization(BufferedReader read, PrintWriter write, Model model) throws IOException {
        boolean authorization = false;

        write.println("Sing up or Sing in");


        String temp = read.readLine();

        if (temp.equals("sing in")) {


            write.println("input Username");
            String username = read.readLine();
            write.println("input password");
            String pass = read.readLine();
            if (model.isUserExist(username, pass) == false) {
                write.println("Incorrect username or password");

            } else {
                authorization = true;
                write.print("Welcome");
            }
            write.flush();
        }
        if (temp.equals("sing up")) {
            ClientThreadFunctions current = allFunctions.get(temp);
            current.requestResponse(read, write, model);
        }
        return authorization;
    }


    @Override
    public void run() {

        try {
            while (true) {
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter write = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);


                if (!authorization) {

                    authorization = authorization(read, write, model);
                } else {

                    write.println(allFunctions.keySet() + " - select command");
                    write.flush();
                    String temp = read.readLine();

                    ClientThreadFunctions current = allFunctions.get(temp);
                    current.requestResponse(read, write, model);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}