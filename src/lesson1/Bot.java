package lesson1;

public class Bot implements Skills {

    private String name;
    private double maxRun;
    private double maxJump;

    public Bot (String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public boolean run(Obstacle obstacle) {
        System.out.println("Робот бежит:");
        if (obstacle.isOvercome(maxRun)) {
            System.out.println("Робот добежал");
            return true;
        } else {
            System.out.println("Робот не добежал. Села батарейка.");
            return false;
        }
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        System.out.println("Робот прыгает:");
        if (obstacle.isOvercome(maxJump)) {
            System.out.println("Робот перепрыгнул.");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Робот: " + "Модель= " + name + ", бежит= " + maxRun + ", прыгает= " + maxJump;
    }
}
