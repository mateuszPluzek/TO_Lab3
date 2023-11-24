import java.util.Random;

public class RandomDouble {
    public static double generate(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
