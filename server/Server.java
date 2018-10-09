package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import util.Log;

public class Server implements Runnable {
	public ServerSocket listener;
	public int clientNumber;
	public int port;
	
	public Server() {
		clientNumber = 0;
		try {
			port = 7777;
			Log.syslog("Server starting");
			listener = new ServerSocket(port);
			Log.syslog("Server started at port " + port);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				clientNumber++;
				Socket socketOfServer = listener.accept();
				Log.syslog("Connected from");
				ServiceThread new_thread = new ServiceThread(socketOfServer, clientNumber);
				Thread thread = new Thread(new_thread);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				listener.close();
			} catch (Exception e) {

			}
		}
	}
}
