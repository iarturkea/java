package com.example.gbchat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final ChatController controller;


    public Client(ChatController controller) {
        this.controller = controller;
    }

    public void openConnection() throws IOException {
        socket = new Socket("localhost",9999);
        in = new DataInputStream(socket.getInputStream());
        out =new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                waitAuth();
                readMsg();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void waitAuth() throws IOException {
        while (true){
            String msg = in.readUTF();
            if (msg.startsWith("/authOk")){
                final String[] split = msg.split("\\p{Blank}+");
                final String nick = split[1];
                controller.setAuth(true);
                controller.addMsg("Успешная автоизация под ником " + nick);
                break;
            }
            controller.addLoginMsg(msg);

        }
    }

    public void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readMsg() throws IOException {
        while (true) {
            final String msg = in.readUTF();
            if ("/end".equals(msg)){
                controller.addMsg("Пользователь отключен");
                controller.setAuth(false);
                break;
            }
            controller.addMsg(msg);

        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
