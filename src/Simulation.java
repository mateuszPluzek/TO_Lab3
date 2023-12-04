import javax.swing.*;
import java.util.Scanner;

public class Simulation {
    private Window window;
    private Board board;
    private Population population;
    private boolean isRunning = true;

    public Simulation(String name, int width, int height, int padding, int startingPopSize) {
        this.board = new Board(width, height, padding);
        this.window = new Window(name, this.board.getWidth(), this.board.getHeight());
        this.population = new Population(startingPopSize, this.board);

        this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
    }

    public void run(int stepsPerSecond) {
        int iterator = 0;
        int healthyPops, immunePops, sickPops;

        while (this.isRunning) {

            while(!window.getPressedStart()) {
                //do nothing while waiting for the simulation to continue
                try {
                    Thread.sleep(1000 / stepsPerSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            advanceOneStep();
            window.frame.repaint();


            try {
                Thread.sleep(1000 / stepsPerSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //can calculate run time using this variable
            iterator++;
            //printing data
            healthyPops = 0;
            immunePops = 0;
            sickPops = 0;
            for(Pop p : population.getPopulation()) {
                if(p.getState() instanceof Healthy)
                    healthyPops++;
                else if(p.getState() instanceof Immune)
                    immunePops++;
                else
                    sickPops++;
            }
            System.out.println("population: " + this.population.getPopulation().size() + " Healthy: " + healthyPops +
                    " Immune: " + immunePops + " Sick: " + sickPops + " Time: " + iterator / 25.0 + "s");
        }
    }

    public void advanceOneStep() {
        this.population.movePopulation();
        this.population.borderCrossingPopulationTest(this.board);
        this.population.tryToInsertNewPop(50, this.board, 10);
        this.population.goThroughIllnesses();
    }
}
