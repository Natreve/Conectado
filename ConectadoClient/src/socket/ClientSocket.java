package socket;

import java.io.*;
import java.net.*;

import application.ClientUI;
import javafx.application.Platform;
import javafx.scene.paint.Color;


public class ClientSocket implements Runnable{
	public int port;
    public String serverAddr;
    public Socket socket;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    public ChatHistory hist;
    public ClientUI ui;
    
    public ClientSocket(ClientUI ui) throws IOException{
    	this.ui = ui;
    	connectToServer();
    }
	@Override
	public void run() {
		boolean keepRunning = true;
		while(keepRunning){
			try {
				Message msg = (Message) In.readObject();
                System.out.println("Incoming Message: " + msg.getType());
                if(msg.getType().equals("Authentication")){
                	handleAuthenticationMsg(msg);
                }
                else if(msg.getType().equals("Chat")){
                	handleChatMsg(msg);
                }
                else if(msg.getType().equals("Signup")){
                	handleAuthenticationMsg(msg);
                }
            }
			catch(Exception e) {
				System.out.println("run exception: " + e.getMessage());
                keepRunning = false;
            }
		}
	}
	public void connectToServer() throws IOException{
		this.port = 13000;
		this.serverAddr = "192.168.56.1";
		this.socket = new Socket(InetAddress.getByName(serverAddr), port);
		Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
	}
	public void connectToServer(int port, String serverAddr) throws IOException{
		this.port = port;
		this.serverAddr = serverAddr;
		this.socket = new Socket(InetAddress.getByName(serverAddr), port);
		Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
	}
	public void handleAuthenticationMsg(Message msg){
		AuthMsg authMsg =  (AuthMsg)msg;
		if(authMsg.getStatusMsg()){
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					ui.getApplicationWindow().setScene(ui.getHomeScene());
				}
			});
			//sceneTitle.setText(activeUser);
			System.out.println("Successful authentication");
			//return true;
		}
		else {
			System.out.println("Unsuccessful authentication");
			ui.actiontarget.setFill(Color.FIREBRICK);
			ui.actiontarget.setText("Login Fail: The username or password can is incorrect");
			
		}//return false;
	}
	public boolean handleChatMsg(Message msg){
		if(msg.getType().equals("Chat")){
			if(msg.getSender().equals(ui.getActiveUser())){
				System.out.println("Rejected Message");
			}
			else{
				System.out.println("Message handled sucessful");
				ui.getContactName().setText(msg.getSender());
				ui.sendMsg(msg.getMsgContent());
			}
		}
		return false;
	}
	public void sendSocket(Message msg){
		try {
			Out.writeObject(msg);
			Out.flush();
			System.out.println("Outgoing to: "+ msg.getRecipient());
		}
		catch (IOException e) {
            System.out.println("Exception SocketClient send()");
        }
	}
	/*
	public boolean serverResponseSocket(){
		try {
			Message msg = (Message) In.readObject();
			if(handleAuthenticationMsg(msg))
				return true;
			else 
				return false;
		}
		catch (Exception e) {
            System.out.println("Exception SocketClient send()");
        }
		return false;
	}*/
}
