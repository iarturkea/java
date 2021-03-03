package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Plats plat = new Plats(100);
        plat.addFood();
        Scanner scr = new Scanner(System.in);
	    Cats[] arrCats = new Cats[5];
	    String name;
	    int stomachCapacity;
        for (int i = 0; i < arrCats.length; i++) {
            System.out.println("Введите имя кота");
            name = scr.nextLine();
            System.out.println("Введите размер его желудка");
            stomachCapacity = scr.nextInt();
            arrCats[i] = new Cats(name, stomachCapacity);
        }
        for (int i = 0; i < arrCats.length; i++) {
            arrCats[i].eat(plat);
        }
        for (int i = 0; i < arrCats.length; i++) {
            arrCats[i].getInfo();
        }

    }
}
