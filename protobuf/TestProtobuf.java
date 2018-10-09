package protobuf;

import protobuf.MessagePB.Message;
import protobuf.MessagePB.Message.Builder;
import protobuf.MessagePB.Message.MessageType;

public class TestProtobuf {

	public static void main(String[] args) {
		Builder mess = Message.newBuilder();
		
		mess.setType(MessageType.CHAT);
		mess.setMess("Hello world");
		
		Message m = mess.build();
		

	}

}
