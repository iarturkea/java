import java.util.Scanner;

public class Cats extends Animals {

    Cats (String name, int count){
        super(name, count);
        this.className = "Кошка";
        this.maxRangeRun = 100;

    }
    @Override
    void swim(int i){
        System.out.println("Вы утопили кошку " + this.name);
    }

    static Animals[] whouIsName(Animals[] arr, int count){
        Scanner scr = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите кличку Кошки №"+(1+i));
            Cats newAnimal = new Cats(scr.nextLine(), count);
            arr[i] = newAnimal;
            count++;

        }
        return arr;
    }

}
