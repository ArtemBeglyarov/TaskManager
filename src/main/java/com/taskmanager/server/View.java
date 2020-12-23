package com.taskmanager.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket()) {

            clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(),9000));
            Scanner scanner = new Scanner(clientSocket.getInputStream());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }


        }
    }
}
