package main;

import client.Client;
import control.HandleButtonClick;
import server.Server;
import view.MainWindow;

public class Main {
	public static MainWindow ui;
	public static Server server;
	public static Client client;
	
	
	public static void main(String[] args) {
		ui = new MainWindow();
		Server s = new Server();
		Thread t = new Thread(s);
		t.start();
		
		System.out.println("Hello");
		new HandleButtonClick();
	}
}
