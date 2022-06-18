package com.company;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;

    public static void main(String[] args) {

        try {
            new  Client().openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openConnection() throws IOException {

        socket = new Socket("127.0.0.1", 9999);
        Messenger messenger = new Messenger(socket);
        messenger.start();
    }
}
