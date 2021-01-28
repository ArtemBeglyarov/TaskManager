package com.taskmanager.server.funcion;

import com.taskmanager.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface ClientThreadFunctions {

    public void яrequestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException;
}
