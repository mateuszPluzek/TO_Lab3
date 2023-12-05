import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Memento implements Serializable {
    String backup;
    private Simulation sim;

    public Memento(Simulation sim) {
        this.sim = sim;
        this.backup = sim.backup();
    }


    public void restore() {
        sim.restore(backup);
    }
}
