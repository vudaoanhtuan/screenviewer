package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainWindow extends JFrame {
	static String title = "Screen Viewer";
	static int w_height = 600;
	static int w_width = 600;
	
	public ButtonPanel buttonPanel;
	public ChatPanel chatPanel;
	public MessageLogPanel messLogPanel;
	public SystemLogPanel sysLogPanel;
	public SendFilePanel sendFilePanel;
	
	void initComponent() {
		buttonPanel = new ButtonPanel();
		chatPanel = new ChatPanel();
		messLogPanel = new MessageLogPanel();
		sysLogPanel = new SystemLogPanel();
		sendFilePanel = new SendFilePanel();
	}
	
	
	public MainWindow() {
		initComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle(title);
		setSize(w_width, w_height);
		setVisible(true);
		setLayout(new GridLayout(5, 1));

		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
	
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 4, 4, 4);
        

	    c.gridx = 0;
	    c.gridy = 0;

	    add(buttonPanel, c);
	    
	    
	    c.gridy++;
	    
	    add(sysLogPanel, c);
	    
	    

	    c.gridy++;
	    
	    add(messLogPanel, c);
	    
	    

	    c.gridy++;
   
	    add(sendFilePanel, c);
	    
	    
	    c.gridy++;

	    add(chatPanel, c);
	 

	}
	
}
