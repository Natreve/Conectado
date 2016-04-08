package socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 156681503809132687L;
	private String message;
	private String sender;
	private String recipient;
	private String timeStamp;
	
	public ChatHistory(){
		super();
		this.message = "";
		this.sender = "";
		this.recipient = "";
		this.timeStamp = "";
	}
	
	public ChatHistory(String message, String sender, String recipient, String timeStamp) {
		super();
		this.message = message;
		this.sender = sender;
		this.recipient = recipient;
		this.timeStamp = timeStamp;
	}
	public static void saveChat(ArrayList<ChatHistory> chatLog, String chatID, ChatHistory newHistory){
		try {
			FileOutputStream fileOutPut = new FileOutputStream(chatID+".history");
		    ObjectOutputStream objOutPut = new ObjectOutputStream(fileOutPut);
		    objOutPut.writeObject(chatLog);
		    objOutPut.close();
		    fileOutPut.close();
		    System.out.println("Message Saved");
		}
		catch(IOException e){
			System.out.println("There was an error with the file: " + e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<ChatHistory> getChatHistory(String chatID){
		/*GETS LOCAL CHAT HISTORY CODE TO BE IMPLEMENTED*/
		try {
			ArrayList<ChatHistory> chatHistory = null;
			FileInputStream fileInput = new FileInputStream(chatID+".history");
			ObjectInputStream objInput = new ObjectInputStream(fileInput);
			chatHistory = (ArrayList<ChatHistory>) objInput.readObject();
			objInput.close();
			fileInput.close();
			return chatHistory;
		}
		catch(Exception e){
			System.out.println("Get Chat History Warning Error1: " + e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList getChatHistory1(String chatID){
		try {
			ArrayList<ChatHistory> chatHistory = null;
			FileInputStream fileInput = new FileInputStream(chatID+".history");
			ObjectInputStream objInput = new ObjectInputStream(fileInput);
			chatHistory = (ArrayList)objInput.readObject();
			objInput.close();
			fileInput.close();
			return chatHistory;
		}
		catch(Exception e){
			System.out.println("Get History Warning Error2: " + e.getMessage());
			return null;
		}
	}
	public String getTimeStamp(){
		return this.timeStamp;
	}
	public void setTimeStamp(){
		Calendar cal = Calendar.getInstance();
		String timeStamp;
		timeStamp = 
				new SimpleDateFormat("E").format(cal.getTime())+","+
				new SimpleDateFormat("h").format(cal.getTime())+":"+
				new SimpleDateFormat("m").format(cal.getTime())+
				new SimpleDateFormat("a").format(cal.getTime());
		System.out.println(timeStamp);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
