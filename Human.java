public class Human implements Act {
    static private String className = "Человек";
    private String name;
    private int maxRunDist;
    private int maxJumpHeight;

    Human(String name, int mrd, int mjh){

        this.name = name;
        this.maxJumpHeight = mjh;
        this.maxRunDist = mrd;

    }


    @Override
    public boolean run(Treadmill trdm) {
        if (trdm.dist > this.maxRunDist){
            System.out.println(className + " " + this.name + " Устал и присел в сторонке");
            return false;
        }
        else {
            System.out.println(className + " " + this.name + " прбежала " + trdm.dist + "м");
            return true;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.height > this.maxJumpHeight){
            System.out.println(className + " " + this.name + " не перепрыгнул " + wall.height + "м");
            return false;
        }
        else {
            System.out.println(className + " " + this.name + " перепрыгул стену" + wall.height + "м");
            return true;
        }

    }
    @Override
    public void sayInfo() {
        System.out.println(className + " " + this.name);
    }

}
