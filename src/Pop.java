/*
* class meant to represent a population  individual who
* can move in random directions inside set boundaries
* and can simulate spreading a sickness
* */
public class Pop {
    private double cord_x;
    private double cord_y;
    private Vector2D direction;
    private double speed;


    public void setCord_x(double cord_x) {
        this.cord_x = cord_x;
    }

    public void setCord_y(double cord_y) {
        this.cord_y = cord_y;
    }

    public void setDirect(Vector2D direct) {
        this.direction = direct;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCord_x() {
        return cord_x;
    }

    public double getCord_y() {
        return cord_y;
    }

    public double getSpeed() {
        return speed;
    }

    public double[] getDirection() {
        return direction.getComponents();
    }
}
