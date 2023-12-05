
public class Main {

    public static void main(String[] args) {

//      constant values representing the framerate
//        int stepsPerSecond = 25;
//        int sleepTime = 1000 / stepsPerSecond;


//        1 meter == 10 pixels

        Simulation scene = new Simulation("test", 650, 650, 0, 200);

        scene.run();

    }
}