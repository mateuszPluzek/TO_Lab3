public interface IVector {
    // returns absolute value of the vector
    public double abs();
    // returns a 2-element array with vector x and y components
    public double[] getComponents();
    public double cdot(IVector param);
}
