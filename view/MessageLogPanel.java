package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;

public class MessageLogPanel extends JPanel {
	public JScrollPane jscroll;
	public JTextPane log;
	public MessageLogPanel() {
		setLayout(new GridLayout());
		setBorder(new CompoundBorder(new TitledBorder("Message Log"), new EmptyBorder(5, 0, 0, 0)));

		log = new JTextPane();
		
		log.setPreferredSize(new Dimension(200, 200));
		
	
		jscroll = new JScrollPane(log);
		
		add(jscroll);
	}
	
	public void log(String user, String mess) {
	   try {
			Document doc = log.getDocument();
			String s = user + ": " + mess + "\n";
			doc.insertString(doc.getLength(), s, null);
	   } catch(Exception exc) {
		   	exc.printStackTrace();
	   }
	}
}
