public class SickWithSymptoms extends State {
    private int timeBeingSick = 0;
    private int maxSickTime = RandomNumber.generate(20,30);
    public SickWithSymptoms(Pop pop) {
        super(pop);
    }
    @Override
    public void progressSickness(Pop p) {
        this.timeBeingSick += 1;
        if(this.timeBeingSick > this.maxSickTime * 25) {
            this.pop.changeState(new Immune(this.pop));
        }
    }

}
