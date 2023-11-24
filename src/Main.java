
public class Main {

    public static void main(String[] args) {
//      constant values representing the framerate
//        int stepsPerSecond = 25;
//        int sleepTime = 1000 / stepsPerSecond;

        Simulation scene = new Simulation("test", 400, 400, 0, 10);

        scene.run(25, 15);

    }
}