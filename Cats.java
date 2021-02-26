package com.company;

import java.util.Scanner;

public class Cats extends Animals {

    public Cats (String name, int count){
        this.className = "Кошка";
        this.name = name;
        this.maxRangeRun = 200;
        this.counter = count + 1;

    }
    @Override
    public void swim(int i){
        System.out.println("Вы утопили кошку");
    }
    static void inputAnimals(int count, Animals[] arrAnimal){
        Scanner scr = new Scanner(System.in);
        for (int i = 0; i < arrAnimal.length; i++){
            System.out.println("Введите кличку Кошки №"+(1+i));
            arrAnimal[i] = new Cats(scr.nextLine(), count);
            count = arrAnimal[i].counter;
        }
    }

}
