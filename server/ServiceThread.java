package server;

import java.net.Socket;

public class ServiceThread implements Runnable {
	public int clientNumber;
	public Socket socketOfServer;

	public ServiceThread(Socket socketOfServer, int clientNumber) {
		this.clientNumber = clientNumber;
		this.socketOfServer = socketOfServer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// write read
	}

}
