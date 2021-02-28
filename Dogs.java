
import java.util.Scanner;

public class Dogs extends Animals {

    public Dogs (String name, int count){
        super(name, count);
        this.className = "Собака";
        this.maxRangeRun = 200;
        this.maxRangSwim = 10;
    }

    static Animals[] whouIsName(Animals[] arr, int count){
        Scanner scr = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите кличку Собаки №"+(1+i));
            Dogs newAnimal = new Dogs(scr.nextLine(), count);
            arr[i] = newAnimal;
            count++;
        }
        return arr;
    }
}
