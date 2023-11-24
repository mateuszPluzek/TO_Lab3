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

    public Pop(Board board) {
        this.cord_x = RandomDouble.generate(0.0, board.getWidth());
        this.cord_y = RandomDouble.generate(0.0, board.getHeight());

        this.speed = RandomDouble.generate(0.0, 2.5);
        this.direction = new Vector2D(RandomDouble.generate(0.0,10.0), RandomDouble.generate(0.0,10.0));
        this.calculateMovement(this.direction, this.speed);
    }

    public Pop(double x, double y, Vector2D direction, double speed) {
        this.cord_x = x;
        this.cord_y = y;
        this.speed = speed;
        this.direction = direction;
        this.calculateMovement(direction, speed);
    }

//  calculates the movement vector using direction and speed
    public void calculateMovement(Vector2D direction, double speed) {
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
//  uses the movement vector to change the current position of the pop
    public void move() {
        this.cord_x += (this.movement.getComponents()[0] / 24.0);
        this.cord_y += (this.movement.getComponents()[1] / 24.0);
    }

//  determines if the current instance should keep going or change it's movement characteristics
    public void movementChangeTest(int chance) {
/*       TODO test if an instance should change it's or movement (may change both at the same time) then
          change it to a new random value
*/
    }
//  when the instance arrives at the area border it tests if it should leave or stay in the area
    public void borderCrossingTest() {
//        TODO test if the object should stay or leave
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
        calculateMovement(this.direction, this.speed);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        calculateMovement(this.direction, this.speed);
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
