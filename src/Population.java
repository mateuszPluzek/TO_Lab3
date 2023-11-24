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
            p.movementChangeTest(10);
        }
    }

    public void borderCrossingPopulationTest(Board board) {
        for (int i = 0; i < this.population.size(); i++) {
            if(this.population.get(i).borderCrossingTest(board)) {
                int tmp = RandomNumber.generate(0,1);
                if(tmp == 1) {
                    this.population.remove(i);
                }
                else {
                    this.population.get(i).setDirect(new Vector2D(this.population.get(i).getDirection().getX() * -1, this.population.get(i).getDirection().getY() * -1));
                }
            }
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
