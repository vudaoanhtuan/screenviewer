package client;

import java.io.IOException;
import java.net.Socket;

import protobuf.MessagePB.Message;
import util.Log;

public class Client implements Runnable {
	public Socket socket;
	public String host;
	public int port;
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void connect() {
		try {
			socket = new Socket(host, port);
//			Log.syslog("Connected to " + host + ":" + port);
		} catch (Exception e) {
			Log.syslog(e.getMessage());
		}
	}
	
	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			Log.syslog(e.getMessage());
		}
	}
	
	public void sendMessage(Message mess) {
		// TODO
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.connect();
		
	}
}
