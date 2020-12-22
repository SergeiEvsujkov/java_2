package lesson1;

public class Person implements Skills {

    private String name;
    private double maxRun;
    private double maxJump;

    public Person (String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public boolean run(Obstacle obstacle) {
        System.out.println("Человек бежит:");
        if (obstacle.isOvercome(maxRun)) {
            System.out.println("Человек добежал");
            return true;
        } else {
            System.out.println("Человек не добежал. Устал.");
            return false;
        }
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        System.out.println("Человек прыгает:");
        if (obstacle.isOvercome(maxJump)) {
            System.out.println("Человек перепрыгнул.");
            return true;
        } else {
            System.out.println("Человек не смог перепрыгнуть.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Человек: " + "Имя= " + name + ", бежит= " + maxRun + ", прыгает= " + maxJump;
    }
}

