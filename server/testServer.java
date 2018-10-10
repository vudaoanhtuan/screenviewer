package server;

import java.io.*;

public class testServer 
{
	public static void main(String[] args) throws Exception
	{
/*		FileInputStream fis = new FileInputStream("./z_sendfile/client/conbocuoi.txt");
		byte[] buffer = new byte[4096];
		fis.read(buffer);
		System.out.println(buffer.toString());
		System.out.println(buffer[4095]);
		String doc2 = new String(buffer, "UTF-8");
		System.out.println(doc2);*/
		Server server = new Server();
		server.run();
	}
}
