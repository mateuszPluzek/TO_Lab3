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

    public void tryToInsertNewPop(int chance, Board board, int sickChance) {
        int test = RandomNumber.generate(0, 1000);
        if(test <= chance) {
            double x, y;
            Vector2D vec = new Vector2D(0.0, 0.0);
            boolean topOrBot = RandomNumber.generate();
            if(topOrBot) {
                x = RandomNumber.generate(0, board.getWidth());
                y = RandomNumber.generate() ? 0 : board.getHeight();
                if(y == 0.0) {
                    vec.setY(5.0);
                }
                else {
                    vec.setY(-5.0);
                }
            }
            else {
                x = RandomNumber.generate() ? 0 : board.getWidth();
                y = RandomNumber.generate(0, board.getHeight());
                if(x == 0.0) {
                    vec.setX(5.0);
                }
                else {
                    vec.setX(-5.0);
                }
            }
            this.population.add(new Pop(board, x, y, vec, RandomNumber.generate(0.0, 25.0, false), sickChance));
        }
    }

    public void goThroughIllnesses() {
        for (Pop p : this.population) {
            if(!(p.getState() instanceof Healthy))
                p.getState().progressSickness(null);
            else {
                Pop closestSick = DistanceFinder.findClosestSickPop(p, this);
                if(closestSick != null && DistanceFinder.distanceBetweenPops(p, closestSick) <= 20.0) {
                    p.getState().progressSickness(closestSick);
                }
                else
                    p.getState().progressSickness(null);
            }
        }
    }

    public void add(Pop newPop) {
        this.population.add(newPop);
    }

    public void remove(int index) {
        this.population.remove(index);
    }

    public Pop get(int index) {
        return this.population.get(index);
    }

    public ArrayList<Pop> getPopulation() {
        return population;
    }
}
