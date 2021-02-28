import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        int whoIs;
        Animals[] arrCats;
        Animals[] arrDogs;
        Cats cat =new Cats("Главная кошка", count);
        Dogs dog = new Dogs("Главнвя собака",count);
        do {

            Scanner scr = new Scanner(System.in);
            System.out.println("Кто пришел?");
            System.out.println("Кошки - введите 1");
            System.out.println("Собаки - введите 2");
            System.out.println("Никого - введите 0");

                do {
                    if (scr.hasNextInt()) {
                        whoIs = scr.nextInt();
                        if (whoIs <= 2 && whoIs >= 0){
                          break;
                        }
                    }
                    scr.nextLine();
                    System.out.println("Так кто пришел?");
                }while (true);

                switch (whoIs) {
                    case 1:
                        arrCats = new Animals [readQuantity()];
                        cat.whouIsName(arrCats, count);
                        count =  cat.countPrint(arrCats);
                        System.out.println("На тренеровке:");
                        for (int i = 0; i < arrCats.length; i++) {
                            Cats.animalInfo(arrCats[i]);
                        }
                        cat.make(cat.findAnimal(arrCats));
                        break;
                    case 2:
                        arrDogs = new Dogs[readQuantity()];
                        Animals[] animals1 = dog.whouIsName(arrDogs, count);
                        count = dog.countPrint(arrDogs);
                        System.out.println("На тренеровке:");
                        for (int i = 0; i < arrDogs.length; i++) {
                            Dogs.animalInfo(arrDogs[i]);
                        }
                        dog.make(dog.findAnimal(arrDogs));
                        count = arrDogs[arrDogs.length-1].counter;
                        break;
                    default:

                }

            System.out.println("Сегодня уже пришло " + count);

        }while (whoIs != 0);

    }

    static int readQuantity() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Сколько пришло?");
        do {
            if (scr.hasNextInt()) {
                int num = scr.nextInt();
                return num;
            }
            scr.nextLine();
            System.out.println("Так сколько пришло?");
        } while (true);
    }

}
