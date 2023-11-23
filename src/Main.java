
public class Main {

    public static void main(String[] args) {
//      constant values representing the framerate
        int stepsPerSecond = 25;
        int sleepTime = 1000 / stepsPerSecond;

        int iterator_flag = 0;


//       main loop
        while(true) {

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