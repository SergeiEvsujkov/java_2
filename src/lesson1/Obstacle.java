package lesson1;

import javax.naming.Name;

public class Obstacle {

    private double sizeObstacle;

    public Obstacle(double sizeObstacle) {
        this.sizeObstacle = sizeObstacle;
    }

    public boolean isOvercome(double maxRunJump) {
        return maxRunJump >= sizeObstacle;
    }

    @Override
    public String toString() {
        return "Величина препятствия = " + sizeObstacle;

    }
}
