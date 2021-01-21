package com.taskmanager.server.funcion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface ClientThreadFunctions {
    public void requestResponse( BufferedReader read,  PrintWriter writ) throws IOException;
}
