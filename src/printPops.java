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

            g.setColor(Color.BLUE);
            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, board.getWidth(), board.getHeight());
    }
}