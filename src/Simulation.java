import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class Simulation implements Serializable{
    private Window window;
    private Board board;
    private Population population;
    private History history;

    public Simulation(String name, int width, int height, int padding, int startingPopSize) {
        this.history = new History();

        this.board = new Board(width, height, padding);
        this.window = new Window(name, this.board.getWidth(), this.board.getHeight(), this);
        this.population = new Population(startingPopSize, this.board);

        this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
    }
    //constructor for case if there are immune people in starting population
    public Simulation(String name, int width, int height, int padding, int startingPopSize, int immuneSize) {
        this.history = new History();

        this.board = new Board(width, height, padding);
        this.window = new Window(name, this.board.getWidth(), this.board.getHeight(), this);
        this.population = new Population(startingPopSize, this.board);
        for(int i = 0; i < immuneSize; i++) {
            this.population.get(i).changeState(new Immune(this.population.get(i)));
        }

        this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
    }

    public void run() {
        int iterator = 0;
        int healthyPops, immunePops, sickPops;
        int stepsPerSecond = 25;

        while (true) {

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

    private void advanceOneStep() {
        this.population.movePopulation();
        this.population.borderCrossingPopulationTest(this.board);
        this.population.tryToInsertNewPop(75, this.board, 10);
        this.population.goThroughIllnesses();
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.population);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.population = (Population) ois.readObject();
            ois.close();

            this.window.frame.getContentPane().remove(1);
            this.window.frame.add(new printPops(this.population.getPopulation(), this.board));
            this.window.frame.setVisible(true);
            this.window.frame.repaint();

        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public Board getBoard() {
        return board;
    }

    public Population getPopulation() {
        return population;
    }

    public Window getWindow() {
        return window;
    }

    public History getHistory() {
        return history;
    }
}
