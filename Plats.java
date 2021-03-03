package com.company;

import java.util.Scanner;

public class Plats {

    int capacity;
    int currentCapacity;

    public Plats(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public void addFood(Plats plate){

        int tmp = readQuantity();
        if(tmp > plate.capacity){
            plate.currentCapacity = plate.capacity;
            System.out.println("Напол просыпалось "+ (tmp - plate.capacity) + " еды и ее пришлось выкинуть");
        }else plate.currentCapacity = tmp;
        System.out.println("В тарелке " + plate.currentCapacity + " еды");
    }

    private int readQuantity() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Ведите сколько еды насыпать в тарелку");
        do {
            if (scr.hasNextInt()) {
                int num = scr.nextInt();
                return num;
            }
            scr.nextLine();
            System.out.println("Так сколько еды насыпать в тарелку?");
        } while (true);
    }
}
