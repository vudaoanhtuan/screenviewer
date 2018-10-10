package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.google.protobuf.TextFormat;

import protobuf.MessagePB.Message;
import protobuf.MessagePB.Message.Builder;
import protobuf.MessagePB.Message.MessageType;

public class Client implements Runnable 
{
	public Socket socket;
	public String host;
	public int port;
	public Scanner scn;
	public DataInputStream dis;
	public DataOutputStream dos;
	
	public Client(String host, int port)
	{
		this.host = host;
		this.port = port;
	}
	
	public void connect()
	{
		try
		{
			socket = new Socket(host, port);
			scn = new Scanner(System.in);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void disconnect()
	{
		try
		{
			socket.close();
			scn.close();
			dis.close();
			dos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendFile(String directory) throws Exception
	{
		if (requestSendFile())
		{
			sendRawFile(directory);
		}
	}
	
	public void sendMessage(String data) throws Exception
	{
		Builder request = Message.newBuilder();
		request.setType(MessageType.CHAT);
		request.setMess(data);
		Message message = request.build();
		sendRawMessage(message);
	}
	
	public boolean requestSendFile() throws Exception
	{
		Builder request = Message.newBuilder();
		request.setType(MessageType.REQUEST_SEND_FILE);
		Message message = request.build();
		sendRawMessage(message);
		
		Message received = receiveMessage();
		if (received.getType().equals(MessageType.ACCEPT))
		{
			return true;
		}
		return false;
	}
	
	public void sendRawFile(String directory) throws Exception
	{
		File file = new File(directory);
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		while (fis.read(buffer) > 0)
		{
			System.out.println("Sending: " + buffer.toString());
			Builder data = Message.newBuilder();
			data.setType(Message.MessageType.SEND_FILE);
			data.setMess(new String(buffer, "UTF-8"));
			Message message = data.build();
			sendRawMessage(message);
		}
		
		Builder end = Message.newBuilder();
		end.setType(Message.MessageType.END_SEND_FILE);
		Message message = end.build();
		sendRawMessage(message);
		
		fis.close();
	}
	
	public void sendRawMessage(Message message) throws Exception
	{
		dos.writeUTF(message.toString());
	}
	
	public Message receiveMessage() throws Exception
	{
		String raw = dis.readUTF();
		Builder received = Message.newBuilder();
		TextFormat.getParser().merge(raw, received);
		Message message = received.build();
		return message;
	}
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				try
				{
					System.out.println("What do you want?");
					String temp = scn.nextLine();
					if (temp.equals("message"))
					{
						System.out.println("Please enter your message: ");
						String message = scn.nextLine();
						sendMessage(message);
					}
					else if (temp.equals("file"))
					{
						System.out.println("Please enter your file directory: ");
						String directory = scn.nextLine();
						sendFile(directory);
					}
					else
					{
						System.out.println("Putang ina mo bobo");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
		}
		finally
		{
			disconnect();
		}
		
	}
}
