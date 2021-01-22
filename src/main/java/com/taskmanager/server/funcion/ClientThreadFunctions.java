package com.taskmanager.server.funcion;

import com.taskmanager.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface ClientThreadFunctions {

    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException;
}
