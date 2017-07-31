package minaTest;

public class Main {
	public static void main(String[] args) {
		MinaClient client = new MinaClient();
		client.connect();
		client.sendMsg2Server("message from client ");
	}
}
