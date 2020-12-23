package com.taskmanager.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(9000);
             Socket socket = serverSocket.accept();
             Scanner scanner = new Scanner(socket.getInputStream())) {

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                if (string.equals("sing up")) {
                    writer.println("up");
                }
                if (string.equals("sing in")) {
                    writer.println("in");
                }
                if (string.equals("exit")) {
                    break;
                }

            }
        }

    }
}