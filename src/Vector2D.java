import java.io.Serializable;

public class Vector2D implements IVector, Serializable {
    private double x;
    private double y;
    // Default constructor
    public Vector2D() {
        this.x = 0.0;
        this.y = 0.0;
    }
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getComponents() {
        return new double[]{this.x, this.y};
    }

    public double abs() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double cdot(IVector param) {
        return this.x * param.getComponents()[0] + this.y * param.getComponents()[1];
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
    // Setters and getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
