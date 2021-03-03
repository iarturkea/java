package com.company;

public class Cats {

    String name;
    boolean satiety;
    int stomachCapacity;

    public Cats (String name, int stomachCapacity){
        this.name =name;
        this.stomachCapacity = stomachCapacity;
        this.satiety = false;
    }

    public  void eat (Plats plat){
        if(plat.currentCapacity > this.stomachCapacity){
            plat.currentCapacity = plat.currentCapacity - this.stomachCapacity;
            this.satiety = true;
            System.out.println(this.name + " наелся");
        }

        else System.out.println( this.name + " даже не подошел к миске, так как в ней не хватает еды");
    }

    public void getInfo(){
        if (this.satiety) System.out.println("Кот " + this.name + " сыт");
        else System.out.println("Кот " + this.name + " голоден");
    }






}
