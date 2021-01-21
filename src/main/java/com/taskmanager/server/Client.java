package com.taskmanager.server;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket()) {

            clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(),9990));
            Scanner scanner = new Scanner(clientSocket.getInputStream());
            Scanner scanner1 = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
            while (true) {
                System.out.println(scanner.nextLine());
                String s = scanner1.nextLine();
                writer.println(s);

            }



        }
    }
}
