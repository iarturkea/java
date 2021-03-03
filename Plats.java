package com.company;

import java.util.Scanner;

public class Plats {

    int capacity;
    int currentCapacity;

    public Plats(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public void addFood(){

        int tmp = readQuantity();
        if(tmp > this.capacity){
            this.currentCapacity = this.capacity;
            System.out.println("Напол просыпалось "+ (tmp - this.capacity) + " еды и ее пришлось выкинуть");
        }else this.currentCapacity = tmp;
        System.out.println("В тарелке " + this.currentCapacity + " еды");
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
