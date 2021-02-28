import java.util.Scanner;

public class Animals {

    String name;
    String className ="Животное";
    int maxRangSwim;
    int maxRangeRun;
    int counter;

    public Animals(){}

    public Animals(String name, int count){
        this.name = name;
        this.maxRangeRun = Integer.MAX_VALUE;
        this.maxRangSwim = Integer.MAX_VALUE;
        this.counter = count+1;

    }



    public static void animalInfo(Animals animal){
        System.out.println(animal.className + " " + animal.name);
    }

    void run (int dist){
        if(dist <= this.maxRangeRun) {
            System.out.println(name + " робежал " + dist + " м.");
        }
        else
            System.out.println(this.className + " " +name + " робежал " + this.maxRangeRun + " м. и упал без сил");
    }

    void swim (int dist){
        if(dist<this.maxRangSwim){
            System.out.println(this.className + " " + name + " проплыл " + dist + " м.");
        }
        else
            System.out.println(this.className + " " +name + " проплыл " + this.maxRangSwim + " м. и утонул");

    }

    int countPrint(Animals[] arr){
        System.out.println(arr[0].className + " пришло - " + arr[arr.length-1].counter);
        return arr[arr.length-1].counter;
    }

     Animals[] whouIsName (Animals[] arr, int count){
        Scanner scr = new Scanner(System.in);
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Введите имя Животного");
                Animals newAnimal = new Animals(scr.nextLine(), count);
                arr[i] = newAnimal;
            }
            return arr;
    }
    static Animals findAnimal (Animals[] arr){

        Scanner scr = new Scanner(System.in);
        do {
            System.out.println("Введите имя или номер Животного");
            if (scr.hasNextInt()) {
                int num = scr.nextInt();
                if (num < arr.length) return arr[num];
            } else {
                String nameIn = scr.nextLine();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].name.equals(nameIn)) return arr[i];

                }
            }
            System.out.println("Такого животнго нет");

        }while (true);

    }

    void make (Animals animal){
        Scanner scr = new Scanner(System.in);

        int num = 0;
        System.out.println("Что делаем?");
        System.out.println("Плыть - 1");
        System.out.println("Бежать - 2");

        do {
            if (scr.hasNextInt() ) {
                num = num+ scr.nextInt();
                if(num == 1 || num == 2) {
                    break;
                }
            }
            scr.nextLine();
            System.out.println("Так что делаем?");
            System.out.println("Плыть - 1");
            System.out.println("Бежать - 2");
        } while (true);
        int dist = 0;

        do {
            System.out.println("Введите дистанцию");
            if (scr.hasNextInt()) {
                dist = scr.nextInt();
                break;

            }
            scr.nextLine();
            System.out.println("Введите дистанцию");

        }while (true);

        switch (num){
            case 1:
                animal.swim(dist);
                break;
            case 2:
                animal.run(dist);
                break;
        }
    }

}




