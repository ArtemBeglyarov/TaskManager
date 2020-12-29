package com.taskmanager.server;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(9000);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new ThreadServer(socket);
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
                PrintWriter writ = new PrintWriter (new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                writ.println("press F");
                String str  = read.readLine();
                System.out.println(str);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}