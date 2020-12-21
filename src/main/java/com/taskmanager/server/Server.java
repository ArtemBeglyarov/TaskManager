package com.taskmanager.server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket( 9000);
        System.out.println("start server");
        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
    }
}
