package com.company;

public class Main {

    public static void main(String[] args) {
	Employees[] emplArray = new Employees[5];
        for (int i = 0; i < emplArray.length; i++) {
            emplArray[i] = new Employees();
        }
        for (int i = 0; i < emplArray.length; i++) {
            if(emplArray[i].age > 40) {
                emplArray[i].printEmployeeInfo();
                System.out.println();
            }
        }
    }


}
