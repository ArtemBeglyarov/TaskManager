package com.taskmanager.server;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket()) {

            clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(),9990));
            Scanner serverInput = new Scanner(clientSocket.getInputStream());
            Scanner userInput = new Scanner(System.in);
            serverInput.useDelimitesr("\\^");
            PrintWriter serverWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
            while (true) {
                System.out.println(serverInput.next());
                String s = userInput.nextLine();
                serverWriter.println(s);


            }
        }
    }
}
