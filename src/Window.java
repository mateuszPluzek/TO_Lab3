import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Window implements Serializable {
    public JFrame frame = new JFrame();

    private Simulation sim;
    private JButton startButton = new JButton("CONTINUE");
    private JButton stopButton = new JButton("STOP");
    private JButton saveButton = new JButton("SAVE");
    private JButton loadButton = new JButton("LOAD");
    private DefaultListModel<String> loadListModel = new DefaultListModel<>();
    private JList<String> loadList = new JList<>();
    private boolean pressedStart;

    public Window(String title, int width, int height, Simulation sim) {
        this.sim = sim;
        this.pressedStart = false;

        frame.setTitle(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//        adding buttons
        JPanel buttonPannel = new JPanel();
        buttonPannel.add(startButton);
        buttonPannel.add(stopButton);
        buttonPannel.add(saveButton);
//        adding list selection
        loadList.setModel(loadListModel);
        loadList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonPannel.add(new JScrollPane(loadList));
        buttonPannel.add(loadButton);
//        attaching the buttons and list to the main window
        frame.add(buttonPannel, BorderLayout.EAST);

//        USELESS CODE, HISTORY WILL BE ALWAYS EMPTY
//        for(int i = 0;i < sim.getHistory().getSavedHistory().size(); i++) {
//            loadListModel.addElement("     " + String.valueOf(i) + "     ");
//        }

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

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sim.getHistory().takeMemento(new Memento(sim));
                loadListModel.clear();
                for(int i = 0;i < sim.getHistory().getSavedHistory().size(); i++) {
                    loadListModel.addElement("          " + String.valueOf(i) + "          ");
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sim.getHistory().loadHistory(Integer.parseInt(loadList.getSelectedValue().strip())).restore();
            }
        });


        frame.setVisible(true);
    }
    public boolean getPressedStart() {
        return this.pressedStart;
    }


}
