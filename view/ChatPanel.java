package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ChatPanel extends JPanel {
	public JTextField input;
	public JButton sendButton;
	public ChatPanel() {

		sendButton = new JButton("Send");
		input = new JTextField(10);
		
		input.setPreferredSize(new Dimension(100, sendButton.getPreferredSize().height));
		
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        add(sendButton, gbc);
  

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(input, gbc);
  
   
	}
}
