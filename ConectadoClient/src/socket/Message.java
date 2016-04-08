package socket;
import java.io.Serializable;

public class Message implements Serializable{
	
    private static final long serialVersionUID = 1L;
    private String type, sender, recipient, timeStamp, msgContent;
    private String[] group;
    
    public Message(){
    	this.type = null;
    	this.sender = null;
    	this.recipient = null;
    	this.timeStamp = null;
    	this.msgContent = null;
    }
    public Message(String type){
    	this.type = type;
    	this.sender = null;
    	this.recipient = null;
    	this.timeStamp = null;
    	this.msgContent = null;
    }
    public Message(String type,String sender, String recipient, String timeStamp, String msgContent){
    	this.type = type;
    	this.sender = sender;
    	this.recipient = recipient;
    	this.timeStamp = timeStamp;
    	this.msgContent =  msgContent;
    }
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String[] getGroup() {
		return group;
	}
	public void setGroup(String[] group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", sender=" + sender + ", recipient=" + recipient + ", timeStamp=" + timeStamp
				+ "]";
	}
	
    
}
