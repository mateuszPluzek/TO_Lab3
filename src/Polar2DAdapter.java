public class Polar2DAdapter implements IVector, IPolar2D {
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }

    public double abs() {
        return this.srcVector.abs();
    }
    public double cdot(IVector param) {
        return this.srcVector.cdot(param);
    }
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }

    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.srcVector.getY(),this.srcVector.getX()));
    }

    public String toString() {
        return "moduł: " + this.abs() + "\nkąt między OX: " + getAngle();
    }

    public Vector2D getSrcVector() {
        return this.srcVector;
    }
}
