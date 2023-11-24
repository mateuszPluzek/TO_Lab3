import java.util.ArrayList;

public class Population {
    private ArrayList<Pop> population;

    public Population() {
        this.population = new ArrayList<>();
    }

    public Population(ArrayList<Pop> population) {
        this.population = population;
    }

    public Population(int size, Board board) {
        this.population = new ArrayList<>();
        for(int i = 0; i < size;i++) {
            this.population.add(new Pop(board));
        }
    }

    public void movePopulation() {
        for (Pop p : this.population) {
            p.move();
        }
    }

    public void add(Pop newPop) {
        this.population.add(newPop);
    }

    public void remove(int index) {
        this.population.remove(index);
    }

    public ArrayList<Pop> getPopulation() {
        return population;
    }
}
