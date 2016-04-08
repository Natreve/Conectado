//Advanced Programming April 2016
//University of Technology
//Shevaun Mckenzie, C'Lloyd Walker, Dwayne Bryan,Andrew Gray,Romone Rose

package socket;

import java.io.*;
import java.net.*;
import java.util.Properties;

import sip.Vsjtalk;
import utilities.DBConnectorFactory;
import utilities.Logging;

public class Server implements Runnable {

	public ServerClientThread clients[];
	public ServerSocket server = null;
	public Thread thread = null;
	private utilities.Props prop = new utilities.Props();
	private Properties props = prop.getProps(); //
	public int port = Integer.parseInt(props.getProperty("portNumber"));
	public int clientCount = 0;
	public Database db;
	private String filePath = props.getProperty("dbPath");	

	public Server() {

		clients = new ServerClientThread[50];
		db = new Database(filePath);
		DBConnectorFactory.checkForDB();

		try {
			server = new ServerSocket(port);
			System.out.println("Server started on IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort() + "\n");
			Logging.getLogger().info("Server started on IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
			start();
		} catch (IOException ioe) {
			System.out.println("Can not bind to port : " + port + "\nRetrying\n");
			Logging.getLogger().error("Can not bind to port : " + port + "\nRetrying\n");
			retryStart(0);// retries but this time selects a random open port
							// and uses it
		} catch (Exception ex) {
			ex.printStackTrace();
			Logging.getLogger().error(ex);
		}
	}

	public Server(int Port) {

		clients = new ServerClientThread[50];
		port = Port;
		db = new Database(filePath);

		try {
			server = new ServerSocket(port);
			System.out.println(
					"Server startet. IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
			Logging.getLogger()
					.info("Server startet. IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
			start();
		} catch (IOException ioe) {
			System.out.println("\nCan not bind to port " + port + ": " + ioe.getMessage());
			Logging.getLogger().error("\nCan not bind to port " + port + ": " + ioe.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			Logging.getLogger().error(ex);
		}
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				System.out.println("\nWaiting for a client ...");
				addThread(server.accept());
			} catch (Exception ioe) {
				System.out.println("\nServer accept error: \n");
				Logging.getLogger().error("\nServer accept error: \n");
				retryStart(0);
			}
		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		if (thread != null) {
			// thread.stop();
			thread = null;
		}
	}

	private int findClient(int ID) {
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	/*Server client request Handlers*/
	public synchronized void handle(int ID, Message msg) {
		AuthMsg authMsg;
		if(msg.getType().equals("Authentication")){
			authMsg = (AuthMsg)msg;
			handleAuthenticationMsg(ID, authMsg);
			System.out.println("Handle " + authMsg.getUsername() + " Authentication");
		}

		else if(msg.getType().equals("Signup")){
			authMsg = (AuthMsg)msg;
			handleSignUp(ID, authMsg);
			System.out.println("Handle " + authMsg.getUsername() + " Signup");
		}
		else if(msg.getType().equals("Chat")){
			handleChatMsg(ID, msg);
			System.out.println("Handle " + msg.getSender() + " Chat Message");
		}
		else if(msg.getType().equals("Voice")){
			handleVoiceMsg(ID, msg);
			System.out.println("Handle " + msg.getSender() + " Voice Message");
		}
		else if(msg.getType().equals("Video")){
			hanldeVideoMsg();
			System.out.println("Handle " + msg.getSender() + " Video Message");
		}
		else if(msg.getType().equals("File")){
			handleFileUpload(ID, msg);
			System.out.println("Handle " + msg.getSender() + " Upload");
		}
	}
	public boolean handleAuthenticationMsg(int ID, AuthMsg msg){
		if(msg.getType().equals("Authentication")){
			if(findUserThread(msg.getSender()) == null){
				if(Auth.auth_login(msg.getUsername(), msg.getPassword())){
					clients[findClient(ID)].username = msg.getUsername();
					clients[findClient(ID)].send(new AuthMsg(true));
					/*broadcast("newuser", "SERVER", msg.sender);
					sendMessageToUser(msg.sender);*/
				}
				else {
					clients[findClient(ID)].send(new AuthMsg(false));
				}
			}
		}
		return false;
	}
	public boolean handleSignUp(int ID, AuthMsg msg){
		 if (msg.getType().equals("Signup")) {
				if (findUserThread(msg.getUsername()) == null) {
					if (!db.userExists(msg.getUsername())) {
						Auth.create(msg.getUsername(), msg.getPassword());
						clients[findClient(ID)].username = msg.getUsername();
						clients[findClient(ID)].send(new AuthMsg("Signup", true));
						System.out.println("TRUE");
					} else {
						clients[findClient(ID)].send(new AuthMsg("Signup", false));
						System.out.println("FALSE");
					}
				} else {
					clients[findClient(ID)].send(new AuthMsg("Signup", false));
				}
			}
		return false;
	}
	public boolean handleChatMsg(int ID, Message msg){
		if(msg.getType().equals("Chat")){
			findUserThread(msg.getRecipient()).send(msg);
			//clients[findClient(ID)].send();
		}
		return false;
	}
	public boolean handleVoiceMsg(int ID, Message msg){
		if(msg.getType().equals("Voice")) {
			String userIP = findUserThread(msg.getSender()).socket.getInetAddress().getHostAddress();
			System.out.println("The IP address from using find user thread :" + userIP);
			// Session meNuhKnow;
			Vsjtalk talk = new Vsjtalk(userIP);
			talk.startPhone();
			System.out.println("phone started");
		}else {
			//System.out.println("Phone not started");
		}
		return false;
	};
	public boolean hanldeVideoMsg(){
		return false;
	};
	
	public boolean handleFileUpload(int ID, Message msg){
		 if (msg.getType().equals("upload_req")) {
				if (msg.getRecipient().equals("All")) {
					//clients[findClient(ID)].send(new Message("message", "SERVER", "Uploading to 'All' forbidden", msg.sender));
				} else {
					//findUserThread(msg.getRecipient()).send(new Message("upload_req", msg.sender, msg.content, msg.recipient));
				}
			} else if (msg.getType().equals("upload_res")) {
				if (!msg.getMsgContent().equals("NO")) {
					@SuppressWarnings("unused")
					String IP = findUserThread(msg.getSender()).socket.getInetAddress().getHostAddress();
					//findUserThread(msg.getRecipient()).send(new Message("upload_res", IP, msg.getMsgContent(), msg.getRecipient()));
				} else {
					//findUserThread(msg.getRecipient()).send(new Message("upload_res", msg.sender, msg.content, msg.recipient));
				}
			}
		return false;
	}
	
	// used to send broadcast messages
	public void broadcast(String type, String sender, String recipient, String timeStamp, String content) {
		Message msg = new Message(type, sender, recipient, timeStamp, content);
		for (int i = 0; i < clientCount; i++) {
			clients[i].send(msg);
		}
	}

	//
	/*
	public void sendOnlineList(String toWhom) {
		for (int i = 0; i < clientCount; i++) {
			findUserThread(toWhom).send(new Message("newuser", "SERVER", clients[i].username, toWhom));
			Message(String type,String sender, String recipient, String timeStamp, String msgContent)
		}
	}
	*/

	// used to send messages to groups by looping through the individuals in the
	// group
	/*public void sendGroupMessage(String type, String sender, String content, String[] toWhom) {
		for (int i = 0; i < toWhom.length; i++) {
			for (int j = 0; j < clientCount; j++) {
				findUserThread(toWhom[i]).send(new Message(type, sender, clients[j].username, toWhom[i]));
			}
		}
	}*/

	public ServerClientThread findUserThread(String usr) {
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].username.equals(usr)) {
				return clients[i];
			}
		}
		return null;
	}

	private void addThread(Socket socket) {
		if (clientCount < clients.length) {
			System.out.println("\nClient accepted: " + socket + "\n");
			Logging.getLogger().info("\nClient accepted: " + socket);
			clients[clientCount] = new ServerClientThread(this, socket);
			try {
				clients[clientCount].open();
				clients[clientCount].start();
				clientCount++;
			} catch (IOException ioe) {
				System.out.println("\nError opening thread: " + ioe + "\n");
				Logging.getLogger().error("\nError opening thread: " + ioe);
			} catch (Exception e) {
				e.printStackTrace();
				Logging.getLogger().error(e);
			}
		} else {
			System.out.println("\nClient refused: maximum " + clients.length + " reached.");
			Logging.getLogger().info("\nClient refused: maximum " + clients.length + " reached.");
		}
	}

	@SuppressWarnings("deprecation")
	public synchronized void removeUser(int ID) {
		int pos = findClient(ID);
		if (pos >= 0) {
			ServerClientThread toTerminate = clients[pos];
			System.out.println("\nRemoving client thread " + ID + " at " + pos + "\n");
			Logging.getLogger().info("\nRemoving client thread " + ID + " at " + pos);
			if (pos < clientCount - 1) {
				for (int i = pos + 1; i < clientCount; i++) {
					clients[i - 1] = clients[i];
				}
			}
			clientCount--;
			try {
				toTerminate.close();
			} catch (IOException ioe) {
				System.out.println("\nError closing thread: " + ioe + "\n");
				Logging.getLogger().error("\nError closing thread: " + ioe);
			} catch (Exception ex) {
				ex.printStackTrace();
				Logging.getLogger().error(ex);
			}
			toTerminate.stop();
			// toTerminate=null;
		}
	}

	public void retryStart(int port) {
		if (this != null) {
			this.stop();
		}
		new Server(port);
	}

	public static void main(String args[]) {
		new Server();
	}
}
