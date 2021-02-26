package com.company;

public class Animals {

    String name;
    String className ="Животное";
    int maxRangSwim;
    int maxRangeRun;
    int counter;


    public Animals(){
    }

    public Animals(String name, int count){
        this.name = name;
        this.maxRangeRun = Integer.MAX_VALUE;
        this.maxRangSwim = Integer.MAX_VALUE;
        this.counter = count;

    }



    public void animalInfo(){
        System.out.println(className + " " + name);
    }

    public void run (int dist){
        if(dist <= this.maxRangeRun) {
            System.out.println(name + " робежал " + dist + " м.");
        }
        else
            System.out.println(this.className + " " +name + " робежал " + this.maxRangeRun + " м. и упал без сил");
    }

    public void swim (int dist){
        if(dist<this.maxRangSwim){
            System.out.println(this.className + " " + name + " проплыл " + dist + " м.");
        }
        else
            System.out.println(this.className + " " +name + " проплыл " + this.maxRangeRun + " м. и утонул");

    }

    public void setClassName (String name){
        className = name;
    }
    public String getClassName (){
        return this.className;
    }





}
