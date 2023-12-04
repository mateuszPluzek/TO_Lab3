public abstract class State {
    protected Pop pop;
    public State(Pop pop) {
        this.pop = pop;
    }

    public abstract void progressSickness(Pop p);



}
