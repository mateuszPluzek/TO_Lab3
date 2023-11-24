
public class Main {

    public static void main(String[] args) {
//      constant values representing the framerate
        int stepsPerSecond = 25;
        int sleepTime = 1000 / stepsPerSecond;

        int iterator_flag = 0;

    // Test population Remove later
        Population population = new Population("id");
        population.add(new Pop(4.5, 4.2, new Vector2D(3, 2), 2));
        population.add(new Pop(7.5, 8.2, new Vector2D(5, 2), 1.6));
        population.add(new Pop(10.5, 3.2, new Vector2D(1, 8), 0.7));

        Window window = new Window("Test", 400, 400);
        window.frame.add(new printPops(population.getPopulation()));

//       main loop
        while(true) {
            population.movePopulation();

            window.frame.repaint();
            //Setting the static framerate
            try {
             Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //exit condition
            iterator_flag++;
            if(iterator_flag >= 10 * stepsPerSecond) {
                break;
            }
        }
    }
}