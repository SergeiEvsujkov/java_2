package lesson1;

public class Cat implements Skills {

    private String name;
    private double maxRun;
    private double maxJump;

    public Cat (String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(Obstacle obstacle) {
        System.out.println("Котик бежит:");
        if (obstacle.isOvercome(maxRun)) {
            System.out.println("Котик добежал");
            return true;
        } else {
            System.out.println("Котик не добежал. Кончился Вискас.");
            return false;
        }
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        System.out.println("Котик прыгает:");
        if (obstacle.isOvercome(maxJump)) {
            System.out.println("Котик перепрыгнул.");
            return true;
        } else {
            System.out.println("Котик не смог перепрыгнуть.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Кот: " + "Кличка= " + name + ", бежит= " + maxRun + ", прыгает= " + maxJump;
    }


}
