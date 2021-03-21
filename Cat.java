public class Cat implements act {
    static String className = "Кошка";
    String name;
    int maxRunDist;
    int maxJumpHeight;

    Cat(String name, int mrd, int mjh){

        this.name = name;
        this.maxJumpHeight = mjh;
        this.maxRunDist = mrd;

    }


    @Override
    public boolean run(Treadmill trdm) {
        if (trdm.dist > this.maxRunDist){
            System.out.println(className + " " + this.name + " Устала и свернулась колачиком");
            return false;
        }
        else {
            System.out.println(className + " " + this.name + " прбежала " + trdm.dist + "м");
            return true;
        }
    }

    @Override
    public void sayInfo() {
        System.out.println(className +" "+this.name);
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.height > this.maxJumpHeight){
            System.out.println(className + " " + this.name + " не перепрыгнула " + wall.height + "м");
            return false;
        }
        else {
            System.out.println(className + " " + this.name + " перепрыгула стену" + wall.height + "м");
            return true;
        }

    }
}
