package com.company;

import javax.swing.table.TableRowSorter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        defProcess();
        parallelProcess();


    }
    private static void defProcess (){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long statTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время просчета " + (System.currentTimeMillis() - statTime));
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

    }
    private static void parallelProcess() throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long statTime = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long divideTime = System.currentTimeMillis() - statTime;
        System.out.println("Время разбиения " + divideTime);
        MyThread thread1 = new MyThread(a1);
        MyThread thread2 = new MyThread(a2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        a1 = thread1.getArr();
        a2 = thread2.getArr();
        long assemblyStartTime = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long assemblyTime = System.currentTimeMillis() - assemblyStartTime;
        System.out.println("Вреия сборки "+ assemblyTime);
        System.out.println("Общее время " + (System.currentTimeMillis() - statTime));

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }


    }
}

class MyThread extends Thread {
    float[] arr;
    MyThread (float[] arr){
        this.arr = arr;
    }
    @Override
    public void run(){
        long statTime = System.currentTimeMillis();
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = (float)(this.arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(Thread.currentThread().getName()+ " Время просчета " + (System.currentTimeMillis() - statTime));

    }

    public float[] getArr() {
        return this.arr;
    }
}
