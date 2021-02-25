package com.company;

import sun.font.FontRunIterator;

import java.util.Scanner;

public class Employees {
    String fullName;
    String position;
    String email;
    String phone;
    int fee;
    int age;
    Employees(){

        Scanner sc =new Scanner(System.in);
        System.out.println("Введите ФИО сотрудника:");
        this.fullName = sc.nextLine();
        System.out.println("Введите должность сотрудника:");
        this.position = sc.nextLine();
        System.out.println("Введите email сотрудника:");
        this.email = sc.nextLine();
        System.out.println("Введите телефон сотрудника:");
        this.phone = sc.nextLine();
        System.out.println("Введите зарплату сотрудника:");
        this.fee = sc.nextInt();
        System.out.println("Введите возраст сотрудника:");
        this.age =sc.nextInt();

    }
    void printEmployeeInfo(){
        System.out.println("ФИО: " + this.fullName);
        System.out.println("должность: " + this.position);
        System.out.println("email: " + this.email);
        System.out.println("телефон: " + this.phone);
        System.out.println("зарплата: " + this.fee);
        System.out.println("возраст: " + this.age);
    }
}

