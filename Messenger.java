package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Messenger extends Thread{
    private final Socket socket;
    DataOutputStream out;
    DataInputStream in;
    Scanner scr = new Scanner(System.in);
    public Messenger(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            new Thread(() -> {

                while (true) {

                    String msg = scr.nextLine();
                    if(socket.isClosed()) {
                        break;
                    }

                    try {
                        out.writeUTF(msg);
                        if (msg.equalsIgnoreCase("/exit")){
                            closeConnection();
                            break;
                        }
                    } catch (IOException e) {
                        break;
                    }


                }
            }).start();
            new Thread(() -> {

                while (true) {
                    if(socket.isClosed()) {
                        break;
                    }
                    try {
                        String msg = in.readUTF();
                        if (msg.equalsIgnoreCase("/exit")){
                            System.out.println("Пришло тех сообщение: " + msg);
                            out.writeUTF(msg);
                            scr.close();
                            closeConnection();
                            break;
                        }
                        System.out.println("Пришло сообщение: " + msg);
                    } catch (IOException e) {
                        break;
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void closeConnection(){
        if(in !=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out !=null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
