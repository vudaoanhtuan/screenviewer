package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {
	static String title = "Screen Viewer";
	static int w_height = 600;
	static int w_width = 600;
	
	public JPanel mainPanel;
	
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

		mainPanel = new JPanel();
		
		EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);	
		
		mainPanel.setBorder(padding);
		
        JPanel head_panel = new JPanel();
        head_panel.setLayout(new BorderLayout());
        
        
        head_panel.add(buttonPanel, BorderLayout.NORTH);
        head_panel.add(sysLogPanel, BorderLayout.CENTER);
        
        
        
        JPanel foot_panel = new JPanel();
        foot_panel.setLayout(new BorderLayout());
        foot_panel.add(messLogPanel, BorderLayout.CENTER);
   
        JPanel pan = new JPanel();
	    pan.setLayout(new GridLayout(2, 1, 5 ,5));
	    
	    pan.add(sendFilePanel);
	    pan.add(chatPanel);
	    
	    
	    foot_panel.add(pan, BorderLayout.SOUTH);

	    mainPanel.setLayout(new GridLayout(2, 1));
	    
	    mainPanel.add(head_panel);
	    mainPanel.add(foot_panel);
	    
	    add(mainPanel);	 

	}
	
}
