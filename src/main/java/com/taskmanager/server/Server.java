package com.taskmanager.server;

import com.taskmanager.Controller;
import com.taskmanager.Model;
import com.taskmanager.Repository;
import com.taskmanager.server.funcion.Authenticating;
import com.taskmanager.server.funcion.ClientThreadFunctions;
import com.taskmanager.server.funcion.CreateUser;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class Server {

    public static void main(String[] args) throws IOException {
        Model model = Model.getInstance();
        Controller controller = Controller.getInstance();
        Repository repository = model.jsonLoad();
        ServerSocket serverSocket = new ServerSocket(9990);
        Map<String,ClientThreadFunctions> allFunctions = new HashMap<>();

        allFunctions.put("sing in", new Authenticating());
        allFunctions.put("sing up",new CreateUser());


        try {

            while (true) {
                Socket socket = serverSocket.accept();
                new ThreadServer(socket,model,controller,repository,allFunctions);
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

    Map<String, ClientThreadFunctions> allFunctions;
    Model model;
    Controller controller;
    Repository repository;
    Socket socket;

    public ThreadServer(Socket socket, Model model, Controller controller, Repository repository, Map<String, ClientThreadFunctions> allFunctions) {
        this.allFunctions = allFunctions;
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

                writ.println("sing in or sing up");
                String temp = read.readLine();

                if (allFunctions.get(temp).equals(temp) ) {
                    ClientThreadFunctions current = allFunctions.get(temp);
                    current.requestResponse(read, writ);
                } else {
                    writ.println("not found argument");
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}