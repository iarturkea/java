package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)  {
        Socket socket = null;


        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Ожидаем подключения");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен");
            Messenger messenger = new Messenger(socket);
            messenger.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
