package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendFilePanel extends JPanel {
	public JTextField jtextfield;
	public JButton sendButton, browseButton;
	
	public SendFilePanel() {
		
		jtextfield = new JTextField(10);
		sendButton = new JButton("Send");
		browseButton = new JButton("Browse");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        
        add(browseButton, gbc);
        gbc.gridx = 2;
        add(sendButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(jtextfield, gbc);
	}
}
