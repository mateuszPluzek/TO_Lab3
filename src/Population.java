import java.util.ArrayList;

public class Population {
    private ArrayList<Pop> population;
    String name;

    public Population(String name) {
        this.population = new ArrayList<>();
        this.name = name;
    }

    public Population(ArrayList<Pop> population, String name) {
        this.population = population;
        this.name = name;
    }

    public void createRandomPopulation(int size) {
//        TODO method that creates size amount of pop instances and puts them in the array
    }

    public void movePopulation() {
        for (Pop p : this.population) {
            p.move();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
