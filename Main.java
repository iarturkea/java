package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите размер поля");
        int razmer = readChislo();

        char[][] pole = new char[razmer][razmer];
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                pole[i][j] = '@';
            }
        }

        printPole(pole);
        zaprosHoda(pole);
        hodPc(pole);
        printPole(pole);


    }
        //Печать поля.
    static void printPole(char[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.print(pole[i][j] + " ");

            }
            System.out.println();
        }

    }
     //Вод числа
    static int readChislo(){
        Scanner sc = new Scanner(System.in);
        do{
            if(sc.hasNextInt())
            {
                return sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Введите размер поля");
        }while(true);
    }
    static void zaprosHoda(char[][] pole){

        Scanner sc = new Scanner(System.in);

        Scanner sc2 = new Scanner(System.in);
        do{
            System.out.println("Введите кординату X для хода");
            if(sc.hasNextInt())
            {
                System.out.println("Введите кординату Y для хода");
                if (sc2.hasNextInt()){
                    int x = sc.nextInt() - 1;
                    int y = sc2.nextInt() - 1;

                    if(x > pole.length || x > pole.length) System.out.println("Такого поля нет");

                    else if(pole[x][y] == '@'){
                        pole[x][y] = 'x';
                        break;
                    }

                    else System.out.println("Поле занято");
                }

            }
            sc.nextLine();
            sc2.nextLine();
        }while(true);

    }
    static void hodPc(char[][] pole){
        do{
            Random rand = new Random();
            int x = rand.nextInt(pole.length);
            int y = rand.nextInt(pole.length);
            if (pole[x][y] == '@'){
                pole[x][y] = 'O';
                break;
            }

        }while (true);

    }
    static void checkWin(char[][] pole, boolean chWin, String winer;){
        int chek = 0;
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if(pole[i][j] != '@'){
                    switch (i){
                        case 0:
                            if (j == 0){
                                    for (int k = j + 1; k < pole.length; k++) {
                                        if(pole[i][j] != pole[i][k]){
                                            chek = 0;
                                            break;
                                        }
                                        chek++;
                                    }
                                    for (int k = i + 1; k < pole.length; k++) {
                                        if(pole[i][j] != pole[k][j]){
                                            chek = 0;
                                            break;
                                        }
                                        chek++;
                                    }
                                    for (int k = i + 1; k < pole.length; k++) {
                                        if(pole[i][j] != pole[k][k]){
                                            chek = 0;
                                            break;
                                        }
                                        chek++;
                                    }
                                    if(chek==2)break;

                            }
                            else {
                                for (int k = j + 1; k < pole.length; k++) {
                                    if (pole[i][j] != pole[i][k]) {
                                        chek = 0;
                                        break;
                                    }
                                    chek++;
                                }
                                if(chek == 2)break;
                            }
                        case 1:
                            int chek = 0;
                            for (int k = i + 1; k < pole.length; k++) {
                                if(pole[i][j] != pole[i][k]){
                                    chek = 0;
                                    break;
                                }
                                chek++;
                            }
                            if(chek == 2)break;
                        case 3:
                            for (int k = i + 1; k < pole.length; k++) {
                                if(pole[i][j] != pole[i][k]){
                                    chek = 0;
                                    break;
                                }
                                chek++;
                            }
                            if(chek==2)break;
                            for (int k = i + 1; k < pole.length; k++) {
                                if(pole[i][j] != pole[k][k]){
                                    chek = 0;
                                    break;
                                }
                                chek++;
                            }
                            if(chek==2)break;

                    }

                }
            }




        }

    }

}