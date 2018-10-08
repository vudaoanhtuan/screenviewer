package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ButtonPanel extends JPanel {

    public JButton connectButton, disconnectButton;
    public JTextField inputHost, inputPort;

    public ButtonPanel() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("Connection"), new EmptyBorder(5, 0, 0, 0)));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
 
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        
        inputHost = new JTextField();
        inputPort = new JTextField();
        
        inputHost.setPreferredSize(new Dimension(300, 26));
        inputPort.setPreferredSize(new Dimension(100, 26));
        
        
        
        add(new Label("Host"), c);
        c.gridx++;
        add(inputHost, c);
        c.gridx++;
        add(new Label("Port"), c);
        c.gridx++;
        add(inputPort, c);
        


        
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=4;

        JPanel buttonPanel = new JPanel();
        
        buttonPanel.add(connectButton);
        buttonPanel.add(disconnectButton);
        
        
        c.fill = GridBagConstraints.HORIZONTAL;

        add(buttonPanel, c);

    }
    

}