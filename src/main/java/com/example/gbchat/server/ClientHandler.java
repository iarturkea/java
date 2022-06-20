package com.example.gbchat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private ChatServer server;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;
    private AuthService authService;

    public ClientHandler(Socket socket, ChatServer server, AuthService authService) {


        try {
            this.server = server;
            this.authService = authService;
            this.socket =socket;
            this.in =new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new  Thread(() -> {
                try {
                    authenticate();
                    readMsg();
                }finally {
                    closeConnection();
                    System.out.println("Client disconnected");
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getNick() {
        return nick;
    }

    private void authenticate() {
        while (true){
            try {
                final String msg = in.readUTF();
                if(msg.startsWith("/auth")){

                    final String[] split = msg.split("\\p{Blank}+", 3);
                    if (split.length < 3){
                        sendMsg("Не верный логин или пароль");
                        continue;
                    }
                    final String login = split[1];
                    final String password = split[2];
                    final String nick = authService.getNickByLoginAndPassword(login, password);

                    if (nick != null){
                        if (server.isNickBusy(nick)) {
                            sendMsg("Пользователь уже на сервисе");
                            continue;
                        }
                        sendMsg("/authOk " + nick);
                        this.nick = nick;
                        server.broadcast(nick + " зашел в чат");
                        server.subscribe(this);
                        break;
                    }else {
                        sendMsg("Не верный логин или пароль");
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection() {
        sendMsg("/end");
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
            server.unsubscribe(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMsg() {
        while (true){
            try {
                String msg = in.readUTF();
                if ("/end".equals(msg))break;

                if(msg.startsWith("/w")){
                    String[] split = msg.split("\\p{Blank}+", 3);
                    if (split.length > 1) {
                        String nickDestination = split[1];
                        if (server.isNickBusy(nickDestination)) {
                            if (split.length >2) {
                                msg = split[2];
                                server.privetMsg("Личное от " + nick + ": " + msg, nickDestination);
                            }else sendMsg("Вы отправлил пустое сообщение");

                        } else sendMsg("Такаой пользователь не залогинен");
                    }
                }else server.broadcast(nick + ": " + msg);



            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
