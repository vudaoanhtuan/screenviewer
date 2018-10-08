package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;


public class SystemLogPanel extends JPanel {
	public JScrollPane jscroll;
	public JTextPane log;
	public SystemLogPanel() {
		setLayout(new GridLayout());
		setBorder(new CompoundBorder(new TitledBorder("System Log"), new EmptyBorder(5, 0, 0, 0)));

		log = new JTextPane();
		log.setPreferredSize(new Dimension(200, 150));
	
		jscroll = new JScrollPane(log);
		
		add(jscroll);
	}
	
	public void log(String mess) {
	   try {
			Document doc = log.getDocument();
			doc.insertString(doc.getLength(), mess + "\n", null);
	   } catch(Exception exc) {
		   	exc.printStackTrace();
	   }
	}
}
