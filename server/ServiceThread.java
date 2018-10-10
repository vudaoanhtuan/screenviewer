package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import protobuf.MessagePB.Message;
import protobuf.MessagePB.Message.Builder;
import protobuf.MessagePB.Message.MessageType;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;

public class ServiceThread implements Runnable
{

	public int clientNumber;
	public Socket socketOfServer;
	public DataInputStream dis;
	public DataOutputStream dos;
	public Scanner scn;
	
	public ServiceThread(Socket socketOfServer, int clientNumber)
	{
		try
		{
			this.clientNumber = clientNumber;
			this.socketOfServer = socketOfServer;
			this.dis = new DataInputStream(this.socketOfServer.getInputStream());
			this.dos = new DataOutputStream(this.socketOfServer.getOutputStream());
			this.scn = new Scanner(System.in);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void disconnect() throws Exception
	{
		socketOfServer.close();
		dis.close();
		dos.close();
	}
	
	public void acceptRequest() throws Exception
	{
		Builder accept = Message.newBuilder();
		accept.setType(MessageType.ACCEPT);
		Message message = accept.build();
		sendMessage(message);
	}
	
	public void rejectRequest() throws Exception
	{
		Builder reject = Message.newBuilder();
		reject.setType(MessageType.REJECT);
		Message message = reject.build();
		sendMessage(message);
	}
	
	public void sendMessage(Message message) throws Exception
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
	
	public void receiveRawFile(String directory) throws Exception
	{
		File file = new File(directory);
		FileOutputStream fos = new FileOutputStream(file);
		while (true)
		{
			Message received = receiveMessage();
			if (received.getType().equals(MessageType.SEND_FILE))
			{
				System.out.println("Received: " + received.getMess());
				System.out.println(received.getMess().length());
				fos.write(received.getMess().getBytes());
			}
			else
			{
				break;
			}
		}
		fos.close();
	}
	
	@Override
	public void run() 
	{
		try
		{
			while (true)
			{
				Message received = receiveMessage();
				if (received.getType().equals(MessageType.CHAT))
				{
					System.out.println("Message from client: " + received.getMess());
				}
				else if (received.getType().equals(MessageType.REQUEST_SEND_FILE))
				{
					System.out.println("Receive file or not?");
					String com = scn.nextLine();
					if (com.equals("accept"))
					{
						System.out.println("Curren directory: " + System.getProperty("user.dir"));
						System.out.println("Enter directory to save file: ");
						String directory = scn.next();
						acceptRequest();
						receiveRawFile(directory);
					}
					else
					{
						rejectRequest();
					}
				}
				else
				{
					System.out.println("Noob");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				disconnect();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
}
