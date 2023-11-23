/*
* class meant to represent a population  individual who
* can move in random directions inside set boundaries
* and can simulate spreading a sickness
* */
public class Pop {
    private double cord_x;
    private double cord_y;
    private Vector2D direction;
    private Vector2D movement;
//    speed is represented in m/s
    private double speed;

    public Pop(double window_h, double window_w) {
//           TODO set random values
    }

    public Pop(double x, double y, Vector2D direction, double speed) {
        this.cord_x = x;
        this.cord_y = y;
        this.speed = speed;
        this.direction = direction;
        this.calculateDirection(direction, speed);
    }


    public void calculateDirection(Vector2D direction, double speed) {
        double ratioX, ratioY;
        if(direction.getComponents()[0] > direction.getComponents()[1]) {
           ratioX = direction.getComponents()[1] / direction.getComponents()[0];
           ratioY = 1.0 - ratioX;
        }
        else if(direction.getComponents()[0] < direction.getComponents()[1]) {
            ratioY = direction.getComponents()[0] / direction.getComponents()[1];
            ratioX = 1.0 - ratioY;
        }
        else {
            ratioX = 0.5;
            ratioY = 0.5;
        }

        this.movement = new Vector2D(speed * ratioX,speed * ratioY);
    }
    public void move() {
        this.cord_x += this.movement.getComponents()[0];
        this.cord_y += this.movement.getComponents()[1];
    }

//Getters and setters
    public void setCord_x(double cord_x) {
        this.cord_x = cord_x;
    }

    public void setCord_y(double cord_y) {
        this.cord_y = cord_y;
    }

    public void setDirect(Vector2D direct) {
        this.direction = direct;
        calculateDirection(this.direction, this.speed);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        calculateDirection(this.direction, this.speed);
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

    public Vector2D getDirection() {
        return direction;
    }

    public Vector2D getMovement() {
        return movement;
    }
}
