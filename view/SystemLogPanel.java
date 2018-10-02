package view;

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

public class SystemLogPanel extends JPanel {
	public JScrollPane jscroll;
	public JTextPane log;
	public SystemLogPanel() {
		setLayout(new GridLayout());
		setBorder(new CompoundBorder(new TitledBorder("System Log"), new EmptyBorder(5, 0, 0, 0)));

		log = new JTextPane();
	
		jscroll = new JScrollPane(log);
		
		add(jscroll);
	}
}
