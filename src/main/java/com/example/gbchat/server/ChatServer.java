package com.example.gbchat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private final Map<String,ClientHandler> clients;

    public ChatServer() {
        this.clients = new HashMap<>();

    }

    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(9999);
            AuthService authService = new InMemoryAuthServer()){
            while (true) {
                System.out.println("Connection waiting");
                final Socket socket = serverSocket.accept();
                new ClientHandler(socket, this, authService);
                System.out.println("Client connected");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void broadcast(String msg) {
        for (Map.Entry<String, ClientHandler> entry: clients.entrySet()) {
            entry.getValue().sendMsg(msg);
        }

    }

    public void privetMsg(String msg, String nick) {
        clients.get(nick).sendMsg(msg);
    }

    public void subscribe(ClientHandler client) {
        clients.put(client.getNick(), client);
    }

    public boolean isNickBusy(String nick) {
        if (clients.containsKey(nick))return true;
        return false;
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client.getNick());
    }
}
