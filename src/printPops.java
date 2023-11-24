import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class printPops extends JPanel {

    private ArrayList<Pop> pops;

    public printPops(ArrayList<Pop> popList) {
        this.pops = popList;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Pop p : this.pops) {
            int centerX = (int) p.getCord_x();
            int centerY = (int) p.getCord_y();
            int radius = 3;

            g.setColor(Color.BLUE);
            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
    }
}