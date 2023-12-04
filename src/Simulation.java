import java.util.Scanner;

public class Simulation {
    private Window window;
    private Board board;
    private Population population;

    private volatile boolean isRunning = true;

    public Simulation(String name, int width, int height, int padding, int startingPopSize) {
        this.board = new Board(width, height, padding);
        this.window = new Window(name, this.board.getWidth(), this.board.getHeight());
        this.population = new Population(startingPopSize, this.board);

        this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
    }

    public void run(int stepsPerSecond) {
        int iterator = 0;

        while (this.isRunning) {
            advanceOneStep();
            window.frame.repaint();

//            System.out.println(this.population.getPopulation().size());

            try {
                Thread.sleep(1000 / stepsPerSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //can calculate run time using this variable
            iterator++;
        }
    }

    public void advanceOneStep() {
        this.population.movePopulation();
        this.population.borderCrossingPopulationTest(this.board);
        this.population.tryToInsertNewPop(70, this.board, 10);
        this.population.goThroughIllnesses();
    }
}
