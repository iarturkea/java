package com.company;

import java.util.Scanner;

public class Dogs extends Animals {

    public Dogs (String name, int count){
        this.className = "Собака";
        this.name = name;
        this.maxRangeRun = 200;
        this.maxRangSwim = 10;
        this.counter = count + 1;
    }

    static void inputAnimals(int count, Animals[] arrAnimal) {
        Scanner scr = new Scanner(System.in);
            for (int i = 0; i < arrAnimal.length; i++) {
                System.out.println("Введите кличку Собаки №"+(1+i));
                arrAnimal[i] = new Dogs(scr.nextLine(), count);
                count = arrAnimal[i].counter;
            }
    }
}
