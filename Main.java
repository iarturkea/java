package com.company;

import sun.font.FontRunIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        Cats cat1 = new Cats("Васька", count);
        cat1.animalInfo();
        cat1.run(250);
        String name = "";
        Animals[] arrCats = whouIs(count);
        count= arrCats[arrCats.length-1].counter;
        Animals[] arrDogs = whouIs(count);
        count = arrDogs[arrDogs.length-1].counter;



       System.out.println(arrDogs.length);


    }
    public static Animals[] whouIs(int count){
        Scanner scr = new Scanner(System.in);
        System.out.println("?");

        System.out.println("Кото пришел?");
        Animals animalDef = new Animals();
        animalDef.setClassName(scr.nextLine());

        System.out.println("Сколько пришло?");
        int num = scr.nextInt();

        if (animalDef.getClassName().equals("Собака")) {
            Animals[] arrDogs = new Animals[num];
            Dogs.inputAnimals(count, arrDogs);
            return arrDogs;
        }

        if (animalDef.getClassName().equals("Кошка")) {
            Animals[] arrCats = new Animals[num];
            Cats.inputAnimals(count, arrCats);
            return arrCats;
        }
        Animals[] arrAnimals = new Animals[num];
        return arrAnimals;

    }
}

