import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class printPops extends JPanel {

    private ArrayList<Pop> pops;
    private Board board;

    public printPops(ArrayList<Pop> popList, Board board) {
        this.pops = popList;
        this.board = board;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Pop p : this.pops) {
            int centerX = (int) p.getCord_x();
            int centerY = (int) p.getCord_y();
            int radius = 5;

            if(p.getState() instanceof Immune)
                g.setColor(Color.CYAN);
            else if(p.getState() instanceof Healthy)
                g.setColor(Color.BLUE);
            else if(p.getState() instanceof SickNoSymptoms)
                g.setColor(Color.GREEN);
            else if(p.getState() instanceof SickWithSymptoms)
                g.setColor(Color.YELLOW);


            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, board.getWidth(), board.getHeight());
    }
}