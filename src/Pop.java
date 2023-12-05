import java.io.Serializable;

/*
* class meant to represent a population  individual who
* can move in random directions inside set boundaries
* and can simulate spreading a sickness
* */
public class Pop implements Serializable {
    private double cord_x;
    private double cord_y;
    private Vector2D direction;
    private Vector2D movement;
//    speed is represented in m/s
    private double speed;

    private State state;

    public Pop(Board board) {
        this.cord_x = RandomNumber.generate(0.0, board.getWidth(), false);
        this.cord_y = RandomNumber.generate(0.0, board.getHeight(), false);

        this.speed = RandomNumber.generate(0.0, 25.0, false);
        this.direction = new Vector2D(RandomNumber.generate(0.0,5.0, true), RandomNumber.generate(0.0,5.0, true));
        this.calculateMovement(this.direction, this.speed);

        this.state = new Healthy(this);
    }

    public Pop(Board board, double x, double y, Vector2D direction, double speed, int chance) {
        this.cord_x = x;
        this.cord_y = y;
        this.speed = speed;
        this.direction = direction;
        this.calculateMovement(direction, speed);
        if(RandomNumber.generate(0, 100) < chance)
            if(RandomNumber.generate(0, 10) < 5)
                this.state = new SickNoSymptoms(this);
            else
                this.state = new SickWithSymptoms(this);
        else
            this.state = new Healthy(this);
    }

//  calculates the movement vector using direction and speed
    public void calculateMovement(Vector2D direction, double speed) {
        double ratioX, ratioY;
        ratioX = Math.abs(direction.getComponents()[0]) / (Math.abs(direction.getComponents()[0]) + Math.abs(direction.getComponents()[1]));
        ratioY = Math.abs(direction.getComponents()[1]) / (Math.abs(direction.getComponents()[0]) + Math.abs(direction.getComponents()[1]));
        this.movement = new Vector2D();

        if(direction.getComponents()[0] < 0.0)
            this.movement.setX(speed * ratioX * -1);
        else
            this.movement.setX(speed * ratioX);

        if(direction.getComponents()[1] < 0.0)
            this.movement.setY(speed * ratioY * -1);
        else
            this.movement.setY(speed * ratioY);
    }
//  uses the movement vector to change the current position of the pop
    public void move() {
        this.cord_x += (this.movement.getComponents()[0] / 25.0);
        this.cord_y += (this.movement.getComponents()[1] / 25.0);
    }

//  determines if the current instance should keep going or change it's movement characteristics
    public void movementChangeTest(int chance) {
        int test = RandomNumber.generate(0, 1000);
        if(test <= chance) {
            this.setSpeed(RandomNumber.generate(0.0, 25.0, false));
            this.setDirect(new Vector2D(RandomNumber.generate(0.0,5.0, true), RandomNumber.generate(0.0,5.0, true)));
        }
    }
//  when the instance arrives at the area border it tests if it should leave or stay in the area
    public boolean borderCrossingTest(Board board) {
        return this.cord_x <= 0.0 || this.cord_x >= board.getWidth() || this.cord_y <= 0.0 || this.cord_y >= board.getHeight();
    }

//    TODO search closest person and if sick you know what


//Getters and setters
    public void setCord_x(double cord_x) {
        this.cord_x = cord_x;
    }

    public void setCord_y(double cord_y) {
        this.cord_y = cord_y;
    }

    public void setDirect(Vector2D direct) {
        this.direction = direct;
        calculateMovement(this.direction, this.speed);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        calculateMovement(this.direction, this.speed);
    }

    public void changeState(State state) {
        this.state = state;
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

    public State getState() {
        return this.state;
    }

}
