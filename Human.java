public class Human implements act {

    static String className = "Человек";
    String name;
    int maxRunDist;
    int maxJumpHeight;

    Human(String name, int mrd, int mjh){

        this.name = name;
        this.maxJumpHeight = mjh;
        this.maxRunDist = mrd;

    }


    @Override
    public boolean run(Treadmill trdm) {
        if (trdm.dist > this.maxRunDist){
            System.out.println(className + this.name + " Устал и присел в сторонке");
            return false;
        }
        else {
            System.out.println(className + this.name + " прбежала" + trdm.dist);
            return true;
        }
    }

    @Override
    public boolean jump(ObstacleCourseElement wall) {
        if (wall.height > this.maxJumpHeight){
            System.out.println(className + this.name + " не перепрыгнул " + wall.height + "м");
            return false;
        }
        else {
            System.out.println(className + this.name + " перепрыгул стену" + wall.height + "м");
            return true;
        }

    }
    @Override
    public void sayInfo() {
        System.out.println(className + " " + this.name);
    }

}
