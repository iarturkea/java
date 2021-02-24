package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char winer;
        int razmer = 0;
        int lnWin =0;

        do {
            System.out.println("Введите размер поля");
            razmer = readNum();
            if (razmer > 2)break;
            System.out.println("Поле меньше 3х");
        }while (true);

        char[][] pole = new char[razmer][razmer];
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                pole[i][j] = '@';
            }
        }
        printPole(pole);
        do {
            System.out.println("Введите длину победы");
            lnWin = readNum() - 1;
            if(lnWin < 1) System.out.println("Слишком короткая победа");
            else if(lnWin + 1 > pole.length)System.out.println("Слишком короткая победа");
            else break;

        }while (true);
        System.out.println("Условия победы " + (lnWin + 1) +" в ряд" );
        do{
            zaprosHoda(pole);
            winer = checkWin(pole, lnWin);
            printPole(pole);
            if(winer != '@')break;
            if (drawCheck(pole))break;
            System.out.println("Ход PC");
            hodPc(pole, lnWin);
            winer = checkWin(pole,lnWin);
            printPole(pole);
            if (winer != '@')break;
        }while (true);
        System.out.println();
        switch (winer) {
            case 'O':
                System.out.println("PC win");
                break;
            case 'x':
                System.out.println("Your win");
                break;
            default:
                System.out.println("Draw");
        }

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
    //Вод Числа
    static int readNum(){
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
            System.out.println("Введите кординату по вертикали для хода");
            if(sc.hasNextInt())
            {
                System.out.println("Введите кординату по горизантали для хода");
                if (sc2.hasNextInt()){
                    int x = sc.nextInt() - 1;
                    int y = sc2.nextInt() - 1;

                    if(x > pole.length || y > pole.length) System.out.println("Такого поля нет");

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
    // Ход ПК
    static void hodPc(char[][] pole, int lnWin){
        int winCount = 0;
        lnWin--;
        boolean block = false;
        //Поиск хода для блока
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if(pole[i][j] == 'x'){
                    //Проверка горизонтали
                    if(i < pole.length - lnWin){
                        winCount = 0;
                        for (int k = i; k < lnWin; k++) {
                            if(pole[k][j] == pole[k+1][j]) winCount++;

                        }
                        if (winCount == lnWin && i+winCount+1 < pole.length && pole[i+winCount+1][j] == '@') {
                            pole[i+lnWin+1][j] = 'O';
                            block = true;
                            break;
                        }
                        if (winCount == lnWin && i > 0 && pole[i-1][j] =='@'){
                            pole[i-1][j] = 'O';
                            block = true;
                            break;
                        }
                    }
                    //Проверка вертикали
                    if(j < pole.length - lnWin){
                        winCount = 0;
                        for (int k = j; k < lnWin; k++) {
                            if (pole[i][k] == pole[i][k+1]) winCount++;

                        }
                        if (winCount == lnWin && j+winCount+1 < pole.length && pole[i][j+winCount+1] == '@') {
                            pole[i][j+lnWin+1] = 'O';
                            block = true;
                            break;
                        }
                        if (winCount == lnWin && j > 0 && pole[i][j - 1] == '@') {
                            pole[i][j - 1] = 'O';
                            block = true;
                            break;
                        }
                    }
                    //Проверка диагонали1
                    if(i < pole.length - lnWin && j < pole.length - lnWin){
                        winCount = 0;
                        for (int k = 1; k <= lnWin; k++) {
                            if(pole[i+winCount][j+winCount] == pole[i+1+winCount][j+1+winCount])winCount++;
                            if(winCount == lnWin || i+winCount+1 == pole.length )break;
                        }
                        if (winCount == lnWin && i+1+winCount < pole.length && j+1+winCount < pole.length && pole[i+1+winCount][j+1+winCount] == '@') {
                            pole[i+1+winCount][j+1+winCount] = 'O';
                            block =true;
                            break;
                        }
                        if(winCount == lnWin && j > 0 && i > 0 && pole[i - 1][j - 1] == '@'){
                            pole[i - 1][j - 1] = 'O';
                        }
                    }
                    //Проверка диагонали2
                    if (i < pole.length - lnWin & j > pole.length - lnWin ){
                        winCount = 0;
                        for (int k = 1; k <= lnWin; k++) {
                            if(pole[i+winCount][j-winCount] == pole[i+1+winCount][j-1-winCount]) winCount++;
                            if(winCount == lnWin || i+winCount+1 == pole.length )break;

                        }
                        if (winCount == lnWin && i+1+winCount < pole.length && j-1-winCount > 0 && pole[i+1+winCount][j-1-winCount] == '@') {
                            pole[i+1+winCount][j-1-winCount] = 'O';
                            block =true;
                            break;
                        }
                        if (winCount == lnWin && i-1-winCount > 0 && j+1+winCount < pole.length && pole[i-1-winCount][j+1+winCount] == '@') {
                            pole[i+1+winCount][j-1-winCount] = 'O';
                            block =true;
                            break;
                        }
                    }

                }

            }
            if (winCount == lnWin & block)break;

        }
        if(!block) {

            do {
                Random rand = new Random();
                int x = rand.nextInt(pole.length);
                int y = rand.nextInt(pole.length);
                if (pole[x][y] == '@') {
                    pole[x][y] = 'O';
                    break;
                }

            } while (true);
        }

    }
    //Прроверка на наличе победы
    static char checkWin(char[][] pole, int lnWin){

        int winCount = 0;
        char winer ='@';
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if(pole[i][j] != '@'){
                    //Проверка горизонтали
                    if(i < pole.length - lnWin){
                        winCount = 0;
                        for (int k = i; k < lnWin; k++) {
                            if(pole[k][j] == pole[k+1][j]) winCount++;

                        }
                        if (winCount == lnWin) {
                            winer = pole[i][j];
                            break;
                        }
                    }
                    //Проверка вертикали
                    if(j < pole.length - lnWin){
                        winCount = 0;
                        for (int k = j; k < lnWin; k++) {
                            if (pole[i][k] == pole[i][k+1]) winCount++;

                        }
                        if (winCount == lnWin) {
                            winer = pole[i][j];
                            break;
                        }
                    }
                    //Проверка диагонали1
                    if(i < pole.length - lnWin & j < pole.length - lnWin){
                        winCount = 0;
                        for (int k = 1; k <= lnWin; k++) {
                            if(pole[i+winCount][j+winCount] == pole[i+1+winCount][j+1+winCount])winCount++;
                            if(winCount == lnWin || i+winCount+1 == pole.length )break;

                        }
                        if (winCount == lnWin) {
                            winer = pole[i][j];
                            break;
                        }
                    }
                    //Проверка диагонали2
                   if (i < pole.length - lnWin & j > pole.length - lnWin ){
                        winCount = 0;
                        for (int k = 1; k <= lnWin; k++) {
                            if(pole[i+winCount][j-winCount] == pole[i+1+winCount][j-1-winCount]) winCount++;
                            if(winCount == lnWin || i+winCount+1 == pole.length )break;

                        }
                        if (winCount == lnWin) {
                            winer = pole[i][j];
                            break;
                        }
                    }

                }

            }
            if (winCount == lnWin)break;

        }
        return winer;

    }
    //проверка на ничью
    static boolean drawCheck(char[][] pole){
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if(pole[i][j] == '@')return false;

            }

        }
        return true;
    }

}
