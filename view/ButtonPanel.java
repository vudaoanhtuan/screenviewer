package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ButtonPanel extends JPanel {

    public JButton connect;

    public ButtonPanel() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("Connection"), new EmptyBorder(5, 0, 0, 0)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
 
        connect = new JButton("Connect");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(connect, gbc);

    }
    

}