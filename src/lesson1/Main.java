package lesson1;

public class Main {
    public static void main(String[] args) {
        Skills[] user = new Skills[3];
        user[0] = new Person("Иван", 5, 1.3);
        user[1] = new Cat("Барсик", 0.9, 1.1);
        user[2] = new Bot("Робик", 13, 2);

        Obstacle[] obstacle = new Obstacle[3];
        obstacle[0] = new Barrier(1);
        obstacle[1] = new Treadmill(4);
        obstacle[2] = new Barrier(0.9);

        for (Skills skills : user) {
            for (Obstacle value : obstacle) {

                System.out.println(skills.toString());
                System.out.println(value.toString());

                if (value instanceof Treadmill) {
                    if (!skills.run(value)) {
                        System.out.println();
                        break;
                    };
                } else {
                    if (!skills.jump(value)) {
                        System.out.println();
                        break;
                    }
                }
                System.out.println();
            }

        }

    }
}
