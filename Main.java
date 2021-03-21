import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int participantsNum;
        int obstaclNum;
        Treadmill trdmDefualt;
        boolean passCheck;
        Wall wallDefualt = new Wall(0);
        System.out.println("Укажите количество участниов");
        participantsNum = readNum();
        System.out.println("Укажите количество препятствий1");

        obstaclNum = readNum();

        act[] participants = new act[participantsNum];
        ObstacleCourseElement[] obstacls = new ObstacleCourseElement[obstaclNum];

        for (int i = 0; i < participants.length; i++) {
            participants[i] = participant();

        }

        for (int i = 0; i < obstacls.length; i++) {
            obstacls[i] = obsticale();
        }

        for (int i = 0; i < participants.length; i++) {
            System.out.print("Трассу проходит ");
            participants[i].sayInfo();
            for (int j = 0; j < obstacls.length; j++) {
                if (obstacls[j] instanceof Treadmill) {
                    trdmDefualt = (Treadmill) obstacls[j];
                    if(!participants[i].run(trdmDefualt)){
                        System.out.println("Участник сошел с дистанции");break;
                    }
                }
                else {
                    wallDefualt = (Wall) obstacls[j];
                    if (!participants[i].jump(wallDefualt))break;
                }



            }

        }
    }


    static int readNum() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите число");
        do {
            if (scr.hasNextInt()) {
                int num = scr.nextInt();
                return num;
            }
            scr.nextLine();
            System.out.println("Введите чилсо");
        } while (true);

    }
    //Выбор участнико
    static act participant(){
        Scanner scr = new Scanner(System.in);
        String name;
        int maxRunDist;
        int maxJumpHeight;
        System.out.println("Выбирите участника");
        System.out.println("Человек - 1");
        System.out.println("Робот - 2");
        System.out.println("Кошка - 3");
        int iter = readNum();
        switch (iter){
            case 1:
                System.out.println("Введите имя человека");
                name =scr.nextLine();
                System.out.println("Сколько он может пробежать?");
                maxRunDist = readNum();
                System.out.println("Как высоко он может прыгнуть?");
                maxJumpHeight = readNum();

                Human human = new Human(name,maxRunDist, maxJumpHeight);
                return human;

            case 2:
                System.out.println("Введите имя Робота");
                name =scr.nextLine();
                System.out.println("Cколько он может пробежать?");
                maxRunDist = readNum();
                System.out.println("Как высоко он может прыгнуть?");
                maxJumpHeight = readNum();

                Robot robot = new Robot(name, maxRunDist, maxJumpHeight);
                return robot;
            case 3:
                System.out.println("Введите кличку кошки");
                name =scr.nextLine();
                System.out.println("Cколько она может пробежать?");
                maxRunDist = readNum();
                System.out.println("Как высоко она может прыгнуть?");
                maxJumpHeight = readNum();

                Cat cat = new Cat(name,maxRunDist, maxJumpHeight);
                return cat;

            default: return null;
        }

    }
    //Выбор препятствий
    static ObstacleCourseElement obsticale(){Scanner scr = new Scanner(System.in);
        String name;
        int obstacleDifficult;
        System.out.println("Выбирите тип препятствия");
        System.out.println("Бег - 1");
        System.out.println("Прыжок - 2");
        int iter = readNum();

        switch (iter){
            case 1:
                System.out.println("Укажите длинну препятствия");
                obstacleDifficult = readNum();
                Treadmill tream = new Treadmill(obstacleDifficult);
                return tream;

            case 2:
                System.out.println("Укажите высоту препятствия");
                obstacleDifficult = readNum();
                Wall wall = new Wall(obstacleDifficult);
                return wall;

            default:return null;

        }



    }

}
