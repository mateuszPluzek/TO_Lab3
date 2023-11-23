public class Main {

    public static void main(String[] args) {

        int stepsPerSecond = 24;
        int sleepTime = 1000 / stepsPerSecond;

        int iterator_flag = 0;

//        TEST OBJECT
        Pop p1 = new Pop(0,0,new Vector2D(3.0,5.0), 1);
//        System.out.println(p1.getDirection());
//        System.out.println(p1.getMovement());

//       main loop
        while(true) {
            System.out.println("p1 coord [x:" + p1.getCord_x() + ", y:" + p1.getCord_y() + "]");
            p1.move();

            //Setting the static framerate
            try {
             Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //exit condition
            iterator_flag++;
            if(iterator_flag >= 10 * 24) {
                break;
            }
        }
    }
}