package client;

import java.io.FileInputStream;

public class testClient 
{
	public static void main(String[] args)
	{
		Client client = new Client("localhost", 7777);
		client.connect();
		client.run(); 
	}
}
