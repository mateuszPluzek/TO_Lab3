import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame = new JFrame();
    public Window(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());

        frame.setVisible(true);
    }
}
