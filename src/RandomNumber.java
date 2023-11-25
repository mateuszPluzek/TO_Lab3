import java.util.Random;

public class RandomNumber {
    public static double generate(double min, double max, boolean flag) {
        Random random = new Random();
        if(flag)
            return (min + (max - min) * random.nextDouble()) - ((min + (max - min) * random.nextDouble()));
        else
            return min + (max - min) * random.nextDouble();
    }

    public static int generate(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
