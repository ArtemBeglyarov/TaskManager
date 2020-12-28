package com.taskmanager.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {

                Socket socket = serverSocket.accept();
                new ThreadServer(socket);

            }
        } catch (IOException e) {

        }

    }
}

class ThreadServer extends Thread {
    Socket socket;

    public ThreadServer(Socket socket) {

        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writ = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String str = read.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("Получено: " + str);
                System.out.println(str);
            }


        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}