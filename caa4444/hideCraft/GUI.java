package caa4444.hideCraft;

import caa4444.hideCraft.misc.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    Container pane;

    JLabel label1 = new JLabel(
            "Select an item to craft!");
    JButton btnStart = new JButton("Start");
    JList<Items> options = new JList<Items>(Items.values());
    GridBagConstraints c = new GridBagConstraints();

    public GUI() {
        this.setLocationRelativeTo(null);
        this.setTitle("Hard Leather Sweatshop by caa4444");
        this.setLayout(new GridBagLayout());
        this.setSize(200, 200);

        pane = getContentPane();

        options.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        options.setLayoutOrientation(JList.VERTICAL);

        label1.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        pane.add(label1, c);

        c.gridy = 1;
        c.gridheight = 4;
        pane.add(options, c);

        c.gridy = 5;
        c.gridheight = 1;
        pane.add(btnStart, c);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startScript(e);
            }
        });
    }

    public void startScript(ActionEvent e) {
        Variables.i = Items.values()[options.getSelectedIndex()];
        this.dispose();
        Variables.guiIsDone = true;
        Variables.timer = new org.powerbot.game.api.util.Timer(1000);
    }
}