import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public JFrame frame = new JFrame();
    private JButton startButton = new JButton("CONTINUE");
    private JButton stopButton = new JButton("STOP");
    private boolean pressedStart;

    public Window(String title, int width, int height) {
        this.pressedStart = false;

        frame.setTitle(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
        JPanel buttonPannel = new JPanel();
        buttonPannel.add(startButton);
        buttonPannel.add(stopButton);
        frame.add(buttonPannel, BorderLayout.EAST);

        //action to take after pressing start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedStart = true;
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedStart = false;
            }
        });


        frame.setVisible(true);
    }
    public boolean getPressedStart() {
        return this.pressedStart;
    }

}
