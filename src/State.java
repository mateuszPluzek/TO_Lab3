import java.io.Serializable;

public abstract class State implements Serializable {
    protected Pop pop;
    public State(Pop pop) {
        this.pop = pop;
    }

    public abstract void progressSickness(Pop p);



}
