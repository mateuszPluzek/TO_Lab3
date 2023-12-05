import java.io.Serializable;

public class Healthy extends State{

    private int timeNearSick = 0;

    public Healthy(Pop pop) {
        super(pop);
    }

    @Override
    public void progressSickness(Pop p) {
        if(p == null) {
            this.timeNearSick = 0;
            return;
        }

        this.timeNearSick += 1;


        if (this.timeNearSick > 3 * 25) {
            if (p.getState() instanceof SickWithSymptoms) {
                if (RandomNumber.generate(0, 10) < 5)
                    this.pop.changeState(new SickNoSymptoms(this.pop));
                else
                    this.pop.changeState(new SickWithSymptoms(this.pop));
            } else if (p.getState() instanceof SickNoSymptoms) {
                if (RandomNumber.generate(0, 10) < 5) {
                    if (RandomNumber.generate(0, 10) < 5)
                        this.pop.changeState(new SickNoSymptoms(this.pop));
                    else
                        this.pop.changeState(new SickWithSymptoms(this.pop));
                }
            }
        }
    }

}
