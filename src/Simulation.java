public class Simulation {
    private Window window;
    private Board board;
    private Population population;

    public Simulation(String name, int width, int height, int padding, int startingPopSize) {
        this.board = new Board(width, height, padding);
        this.window = new Window(name, this.board.getWidth(), this.board.getHeight());
        this.population = new Population(startingPopSize, this.board);

        this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
    }

    public void run(int stepsPerSecond, int simulationTime) {
        int iterator = 0;

        while (true) {
            advanceOneStep();
            window.frame.repaint();

            try {
                Thread.sleep(1000 / stepsPerSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //exit condition
            iterator++;
            if(iterator >= simulationTime * stepsPerSecond) {
                break;
            }
        }
    }

    public void advanceOneStep() {
        this.population.movePopulation();
    }
}
