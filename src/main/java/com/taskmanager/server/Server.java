package com.taskmanager.server;

import com.taskmanager.Controller;
import com.taskmanager.Model;
import com.taskmanager.server.funcion.ClientThreadFunctions;
import com.taskmanager.server.funcion.CreateUser;
import com.taskmanager.server.funcion.RemoveUser;

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
        allFunctions.put("remove user", new RemoveUser());

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
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    Map<String, ClientThreadFunctions> allFunctions;
    Model model;
    Controller controller;
    Socket socket;

    public ThreadServer(Socket socket, Model model, Controller controller, Map<String, ClientThreadFunctions> allFunctions) {
        this.allFunctions = allFunctions;
        this.socket = socket;
        this.model = model;
        this.controller = controller;
        start();
    }

    public String authorization(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        String authorization = "user is not authorized";

        writ.println("input Username");
        String username = read.readLine();
        writ.println("input password");
        String pass = read.readLine();
        if (model.checkUsers(username, pass) == 0) {
            writ.println("Incorrect username or password");

        } else {
            authorization = "user is authorized";
            writ.println("Welcome");
        }

        return authorization;
    }



    @Override
    public void run() {

        try {
            while (true) {
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writ = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);




                writ.println("log in to use the task manager");
                writ.println(allFunctions.keySet());

                String temp = read.readLine();

                if (allFunctions.containsKey(temp)) {
                    while (threadLocal.equals("user is not authorized") ) {

                        temp = "sing in";
                    }
                        ClientThreadFunctions current = allFunctions.get(temp);
                        current.requestResponse(read, writ, model);
                }
                if (temp.equals("sing in")) {
                    threadLocal.set(authorization(read, writ,model));
                }
                writ.println("not found argument");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}