package socket;

@SuppressWarnings("serial")
public class AuthMsg extends Message {
	private String username, password;
	private boolean statusMsg;
	
	public AuthMsg() {
		super("Authentication");
		this.username = null;
		this.password = null;
		this.statusMsg = false;
	}
	public AuthMsg(boolean statusMsg) {
		super("Authentication");
		this.username = null;
		this.password = null;
		this.statusMsg = statusMsg;
	}
	public AuthMsg(String type, boolean statusMsg) {
		super(type);
		this.username = null;
		this.password = null;
		this.statusMsg = statusMsg;
	}
	public AuthMsg(String username, String password, String timeStamp, boolean statusMsg) {
		super("Authentication");
		this.username = username;
		this.password = password;
		this.statusMsg = statusMsg;
	}
	
	public AuthMsg(String type, String username, String password, String timeStamp, boolean statusMsg) {
		super(type);
		this.username = username;
		this.password = password;
		this.statusMsg = statusMsg;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(boolean statusMsg) {
		this.statusMsg = statusMsg;
	}

	@Override
	public String toString() {
		return "AuthMsg [username=" + username + ", password=" + password + ", statusMsg=" + statusMsg
				+ "]";
	}

}
