package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Client;
import main.Main;
import util.Log;

public class HandleButtonClick {
	public HandleButtonClick() {
		Main.ui.buttonPanel.connectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String host = Main.ui.buttonPanel.inputHost.getText();
				String portString = Main.ui.buttonPanel.inputPort.getText();
				int port = Integer.parseInt(portString);
				
				Main.client = new Client(host, port);
				Thread client_thread = new Thread(Main.client);
				client_thread.start();
				Log.syslog("Button clicked");
				
			}
		});
	}
}
