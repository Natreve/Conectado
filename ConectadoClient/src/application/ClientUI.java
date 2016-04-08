package application;
/**/
import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import socket.AuthMsg;
import socket.ChatHistory;
import socket.ClientSocket;
import socket.Message;
import socket.TimeStamp;


public class ClientUI extends Application {
	public ClientSocket socket;
	public Thread clientThread;
	/**
	 * LOGIN UI COMPONENTS
	 * **/
	private Text sceneTitle;
	private Label userName;
	private JFXTextField userTextField;
	private Label password;
	private JFXPasswordField passwordField;
	private JFXButton signInBtn;
	private JFXButton signUpBtn;
	public final Text actiontarget = new Text(); // For testing
	private GridPane grid;
	private HBox loginHBox;
	private Scene loginScene;
	
	/**
	 * HOME UI COMPONENTS
	 **/
	@SuppressWarnings("unused")
	private JFXButton signOutBtn;
	@SuppressWarnings("unused")
	private JFXButton addContactBtn;
	@SuppressWarnings("unused")
	private JFXSpinner spinner;
	private HBox mainHomeUI;
	private JFXTabPane menuTab;
	private Tab contactTab;
	private Tab messageTab;
	private JFXListView<Label> contactListView;
	private JFXListView<Label> messageListView;
	private Label[] contactList;
	private Label[] messageList;
	@SuppressWarnings("unused")
	private ObservableList<Label> observableContactListData;
	private Scene homeScene;
	private Stage applicationWindow;
	/**
	 * CHAT UI COMPONENTS
	 **/
	private JFXButton sendBtn;
	private JFXButton voiceBtn;
	private JFXButton videoBtn;
	private JFXButton backBtn;
	private JFXButton fileUploadBtn;
	private JFXButton createChatGroupBtn;
	private JFXTextField msgField;
	private Label contactName;
	private Label userChatBubble;
	private Label contactChatBubble;
	
	private BorderPane mainChatUI;
	private HBox menuBtnGroup;
	private HBox menuGroup;
	private HBox messageMenuGroup;
	private HBox menuGroupBckContact;
	private GridPane chatBubbleLayout;
	private ScrollPane chatAreaLayout;
	private Scene chatScene;
	private DropShadow dropShadow;
	private int msgCount = 2; //THIS FIELD WILL NEED TO GET ACTUAL MESSAGE COUNT
	private String activeUser;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.applicationWindow = primaryStage;
			//Platform.setImplicitExit(false);
			lunchLoginUI();
			lunchHomeUI();
			lunchChatUI();
			registerListeners();
			primaryStage.setTitle("Conectado"); //Sets window title
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			primaryStage.setScene(loginScene); // Add panel to window
			primaryStage.show();
			try {
				socket = new ClientSocket(this);
				clientThread = new Thread(socket);
				clientThread.start();
			} catch (IOException e1) {
				System.out.println("Server not found");
				actiontarget.setFill(Color.FIREBRICK);
	            actiontarget.setText("No server Connection");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * 	LOGIN UI FUNCTIONS
	 * **/
	public void lunchLoginUI() {
		initializeLoginComponents();
		addLoginComponentsToLayouts();
		System.out.println("Login Lunched");
	}
	public void initializeLoginComponents(){
		this.sceneTitle = new Text("Welcome");
		this.userName = new Label("User Name:");
		this.userTextField = new JFXTextField();
		this.password = new Label("Password:");
		this.passwordField = new JFXPasswordField();
		this.signInBtn = new JFXButton("Sign in");
		this.signUpBtn =  new JFXButton("Sign up");
		this.grid = new GridPane(); // Creates a grid layout
		this.loginHBox = new HBox(10);// Creates a horizontal layout
		//StyleSheet for UI
		signInBtn.getStyleClass().add("button-raised");
		
		/**
		 	Layout Setup -
		 
		 **/
		
		grid.setAlignment(Pos.CENTER); // Aligns grid layout
		grid.setHgap(10); //Adds 10px spacing between the rows
		grid.setVgap(10); //Adds 10px spacing between the columns
		grid.setPadding(new Insets(25, 25, 25, 25)); // Adds  25px space around the edges of the grid pane
		loginHBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		this.loginScene = new Scene(grid, 600, 500); //Adds grid to scene
		/**
	 		Style Components - 
	 		Adding css #ID to elements for styling
		 **/
		sceneTitle.setId("welcome-text");
		actiontarget.setId("actiontarget");
		actiontarget.setWrappingWidth(200);
		loginScene.getStylesheets().add(ClientUI.class.getResource("UI.css").toExternalForm());	
	}
	public void addLoginComponentsToLayouts(){
		//Add components to HBoxLayout
		loginHBox.getChildren().add(signInBtn);
		loginHBox.getChildren().add(signUpBtn);
		//Add components to GridLayout
		grid.add(sceneTitle, 0, 0, 2, 1); //add sceneTitle to column 0, row 0 and a calspan of 2 and rowspan of 1
		grid.add(userName, 0, 1);
		grid.add(userTextField, 1, 1);
		grid.add(password, 0, 2);
		grid.add(passwordField, 1, 2);
		grid.add(actiontarget, 1, 6);
		grid.add(loginHBox, 0, 4);
		//grid.setGridLinesVisible(true); //Make gridline visible
	}
	/**
	 * HOME UI FUNCTIONS
	 **/
	public void initializeHomeComponents() {
		this.mainHomeUI = new HBox();
		this.signOutBtn = new JFXButton();
		this.addContactBtn = new JFXButton();
		this.spinner = new JFXSpinner();
		this.menuTab = new JFXTabPane();
		this.contactTab = new Tab();
		this.messageTab = new Tab();
		this.contactListView = new JFXListView<Label>();
		this.messageListView = new JFXListView<Label>();
		contactTab.setText("Contact");
    	messageTab.setText("Message");
		contactTab.setContent(new Label("No Contact"));
		messageTab.setContent(new Label("No Messages"));
		contactTab.setStyle("-fx-pref-width: 100;");
    	messageTab.setStyle("-fx-pref-width: 100;");
	}
	public void handleContactData(){
		try {
		Label[] contactList = {new Label("Andrew"), new Label("Shevon"), new Label("Romone"), new Label("Junior")};
		ObservableList<Label> observableContactListData = FXCollections.observableArrayList(contactList);
		contactListView.setItems(observableContactListData);
		
		contactTab.setContent(contactListView);
        messageTab.setContent(new Label("No message"));
		
		}catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}
	}
	public void handleMessageData(){
		
	}
	public void addHomeComponentsToLayouts() {
		menuTab.getTabs().add(contactTab);
		menuTab.getTabs().add(messageTab);
		//HBox.setHgrow(menuTab, Priority.ALWAYS);
		this.homeScene = new Scene(menuTab, 420, 600);
		homeScene.getStylesheets().add(ClientUI.class.getResource("UI.css").toExternalForm());
		
	}
	public void lunchHomeUI() {
		initializeHomeComponents();
		addHomeComponentsToLayouts();
		handleContactData();
	}
	/**
	 * CHAT UI FUNCTIONS
	 **/
	public void initializeChatComponents() {
		/*Initialize Drop shadow effect*/
		this.dropShadow = new DropShadow();
		 dropShadow.setRadius(2.0);
		 dropShadow.setOffsetX(1.5);
		 dropShadow.setOffsetY(1.0);
		 dropShadow.setColor(Color.color(0, 0, 0, 0.2));
		/*Initialize Icons*/
		SVGPath sendBtnIcon = new SVGPath();
		SVGPath videoBtnIcon = new SVGPath();
		SVGPath voiceBtnIcon = new SVGPath();
		SVGPath backBtnIcon =  new SVGPath();
		SVGPath fileUploadIcon = new SVGPath();
		SVGPath createChatGroupIcon = new SVGPath();
		sendBtnIcon.setContent("M1.286,12.465c-0.685,0.263-1.171,0.879-1.268,1.606c-0.096,0.728,0.213,1.449,0.806,1.88l6.492,4.724L30.374,2.534    L9.985,22.621l8.875,6.458c0.564,0.41,1.293,0.533,1.964,0.33c0.67-0.204,1.204-0.713,1.444-1.368l9.494-25.986    c0.096-0.264,0.028-0.559-0.172-0.756c-0.199-0.197-0.494-0.259-0.758-0.158L1.286,12.465z");
		videoBtnIcon.setContent("M500.491,83.65c-2.474-0.95-4.853-1.427-7.139-1.427c-5.14,0-9.418,1.812-12.847,5.426l-115.06,114.776v-47.108   c0-22.653-8.042-42.017-24.126-58.102c-16.085-16.083-35.447-24.125-58.102-24.125H82.224c-22.648,0-42.016,8.042-58.102,24.125   C8.042,113.3,0,132.664,0,155.317v200.996c0,22.651,8.042,42.014,24.123,58.098c16.086,16.084,35.454,24.126,58.102,24.126h200.994   c22.654,0,42.017-8.042,58.102-24.126c16.084-16.084,24.126-35.446,24.126-58.098v-47.397l115.06,115.061   c3.429,3.613,7.707,5.424,12.847,5.424c2.286,0,4.665-0.476,7.139-1.424c7.427-3.237,11.136-8.85,11.136-16.844V100.499   C511.626,92.501,507.917,86.887,500.491,83.65z");
		voiceBtnIcon.setContent("M577.83,456.128c1.225,9.385-1.635,17.545-8.568,24.48l-81.396,80.781    c-3.672,4.08-8.465,7.551-14.381,10.404c-5.916,2.857-11.729,4.693-17.439,5.508c-0.408,0-1.635,0.105-3.676,0.309    c-2.037,0.203-4.689,0.307-7.953,0.307c-7.754,0-20.301-1.326-37.641-3.979s-38.555-9.182-63.645-19.584    c-25.096-10.404-53.553-26.012-85.376-46.818c-31.823-20.805-65.688-49.367-101.592-85.68    c-28.56-28.152-52.224-55.08-70.992-80.783c-18.768-25.705-33.864-49.471-45.288-71.299    c-11.425-21.828-19.993-41.616-25.705-59.364S4.59,177.362,2.55,164.51s-2.856-22.95-2.448-30.294    c0.408-7.344,0.612-11.424,0.612-12.24c0.816-5.712,2.652-11.526,5.508-17.442s6.324-10.71,10.404-14.382L98.022,8.756    c5.712-5.712,12.24-8.568,19.584-8.568c5.304,0,9.996,1.53,14.076,4.59s7.548,6.834,10.404,11.322l65.484,124.236    c3.672,6.528,4.692,13.668,3.06,21.42c-1.632,7.752-5.1,14.28-10.404,19.584l-29.988,29.988c-0.816,0.816-1.53,2.142-2.142,3.978    s-0.918,3.366-0.918,4.59c1.632,8.568,5.304,18.36,11.016,29.376c4.896,9.792,12.444,21.726,22.644,35.802    s24.684,30.293,43.452,48.653c18.36,18.77,34.68,33.354,48.96,43.76c14.277,10.4,26.215,18.053,35.803,22.949    c9.588,4.896,16.932,7.854,22.031,8.871l7.648,1.531c0.816,0,2.145-0.307,3.979-0.918c1.836-0.613,3.162-1.326,3.979-2.143    l34.883-35.496c7.348-6.527,15.912-9.791,25.705-9.791c6.938,0,12.443,1.223,16.523,3.672h0.611l118.115,69.768    C571.098,441.238,576.197,447.968,577.83,456.128z");
		backBtnIcon.setContent("m88.6,121.3c0.8,0.8 1.8,1.2 2.9,1.2s2.1-0.4 2.9-1.2c1.6-1.6 1.6-4.2 0-5.8l-51-51 51-51c1.6-1.6 1.6-4.2 0-5.8s-4.2-1.6-5.8,0l-54,53.9c-1.6,1.6-1.6,4.2 0,5.8l54,53.9z");
		fileUploadIcon.setContent("M324.572,42.699c-35.419-35.419-92.855-35.419-128.273,0L19.931,219.066c-26.575,26.575-26.575,69.635,0,96.211     c21.904,21.904,54.942,25.441,80.769,11.224c2.698-0.136,5.351-1.156,7.415-3.197l176.367-176.367     c17.709-17.709,17.709-46.416,0-64.125s-46.416-17.709-64.125,0L76.052,227.116c-4.422,4.422-4.422,11.61,0,16.031     c4.422,4.422,11.61,4.422,16.031,0L236.388,98.843c8.866-8.866,23.219-8.866,32.063,0c8.866,8.866,8.866,23.219,0,32.063     L100.088,299.268c-17.709,17.709-46.416,17.709-64.125,0s-17.709-46.416,0-64.125L212.33,58.73     c26.575-26.575,69.635-26.575,96.211,0c26.575,26.575,26.575,69.635,0,96.211L148.205,315.277c-4.422,4.422-4.422,11.61,0,16.031     c4.422,4.422,11.61,4.422,16.031,0l160.336-160.336C359.991,135.554,359.991,78.118,324.572,42.699z");
		createChatGroupIcon.setContent("M269.493,295.159c32.082-23.527,51.332-62.026,51.332-102.664c0-70.581-57.749-128.33-128.33-128.33     s-128.33,57.749-128.33,128.33c0,40.638,19.249,79.137,51.332,102.664C53.471,322.963,8.555,380.712,0,449.155h42.777     c10.694-72.72,74.859-128.33,149.718-128.33s139.024,55.61,149.718,128.33h42.777     C376.435,380.712,331.519,322.964,269.493,295.159L269.493,295.159z M192.495,278.048c-47.055,0-85.553-38.499-85.553-85.553     s38.499-85.553,85.553-85.553s85.553,38.499,85.553,85.553S239.55,278.048,192.495,278.048L192.495,278.048z");
		sendBtnIcon.getStyleClass().add("sendIcon");
		videoBtnIcon.getStyleClass().add("videoCallIcon");
		voiceBtnIcon.getStyleClass().add("voiceCallIcon");
		backBtnIcon.getStyleClass().add("backBtnIcon");
		fileUploadIcon.getStyleClass().add("attcheFileIcon");
		createChatGroupIcon.getStyleClass().add("chatGroupIcon");
		/*Initialize Buttons*/
		this.sendBtn = new JFXButton();
		this.videoBtn = new JFXButton();
		this.voiceBtn = new JFXButton();
		this.backBtn =  new JFXButton();
		this.fileUploadBtn = new JFXButton();
		this.createChatGroupBtn = new JFXButton();
		sendBtn.setGraphic(sendBtnIcon);
		sendBtn.getStyleClass().add("btnCircle");
		videoBtn.setGraphic(videoBtnIcon);
		videoBtn.getStyleClass().add("menuCircleBtn");
		voiceBtn.setGraphic(voiceBtnIcon);
		voiceBtn.getStyleClass().add("menuCircleBtn");
		backBtn.setGraphic(backBtnIcon);
		backBtn.getStyleClass().add("backBtn");
		fileUploadBtn.setGraphic(fileUploadIcon);
		fileUploadBtn.getStyleClass().add("attcheFileBtn");
		createChatGroupBtn.setGraphic(createChatGroupIcon);
		createChatGroupBtn.getStyleClass().add("menuCircleBtn");
		
		sendBtnIcon.scaleXProperty().bind(sendBtn.widthProperty().divide(50));
		sendBtnIcon.scaleYProperty().bind(sendBtn.heightProperty().divide(50));
		videoBtnIcon.scaleXProperty().bind(videoBtn.widthProperty().divide(800));
		videoBtnIcon.scaleYProperty().bind(videoBtn.heightProperty().divide(800));
		voiceBtnIcon.scaleXProperty().bind(voiceBtn.widthProperty().divide(800));
		voiceBtnIcon.scaleYProperty().bind(voiceBtn.heightProperty().divide(800));
		backBtnIcon.scaleXProperty().bind(backBtn.widthProperty().divide(400));
		backBtnIcon.scaleYProperty().bind(backBtn.heightProperty().divide(400));
		fileUploadIcon.scaleXProperty().bind(fileUploadBtn.widthProperty().divide(800));
		fileUploadIcon.scaleYProperty().bind(fileUploadBtn.heightProperty().divide(800));
		createChatGroupIcon.scaleXProperty().bind(createChatGroupBtn.widthProperty().divide(800));
		createChatGroupIcon.scaleYProperty().bind(createChatGroupBtn.heightProperty().divide(800));
		
		/*Initialize Message field*/
		msgField = new JFXTextField();
		msgField.setPromptText("Type Something");
		msgField.getStyleClass().add("ui-textField-bubble");
		msgField.setStyle("-fx-focus-color:#FF9966");
		
		/*Initialize Chat bubbles*/
		userChatBubble = new Label();
		userChatBubble.setWrapText(true);
		userChatBubble.getStyleClass().add("user-chat-bubble");
		userChatBubble.setEffect(dropShadow);
		contactChatBubble = new Label();
		contactChatBubble.setWrapText(true);
		contactChatBubble.getStyleClass().add("contact-chat-bubble");
		contactChatBubble.setEffect(dropShadow);
		/*Initialize Layouts*/
		chatBubbleLayout = new GridPane();
		chatBubbleLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		ColumnConstraints c1 = new ColumnConstraints();
	    c1.setPercentWidth(100);
	    chatBubbleLayout.getColumnConstraints().add(c1);
		chatBubbleLayout.setAlignment(Pos.CENTER);
		chatBubbleLayout.setHgap(10);
		chatBubbleLayout.setVgap(10);
		chatBubbleLayout.setPadding(new Insets(25, 25, 25, 25));
		chatAreaLayout = new ScrollPane();
		chatAreaLayout.setFitToWidth(true);
		 
		 
		/*Initialize component groups*/
		menuBtnGroup = new HBox();
		menuBtnGroup.setPadding(new Insets(15, 12, 15, 12));
		menuBtnGroup.setSpacing(10);
		menuBtnGroup.setAlignment(Pos.CENTER_RIGHT);
		messageMenuGroup = new HBox();
		messageMenuGroup.setPadding(new Insets(15, 12, 15, 12));
		messageMenuGroup.setSpacing(10);
		menuGroup = new HBox();
		menuGroup.setPadding(new Insets(15, 12, 15, 12));
		menuGroup.setSpacing(10);
		menuGroup.getStyleClass().add("chat-menu");
		menuGroup.setEffect(dropShadow);
		menuGroupBckContact = new HBox();
		menuGroupBckContact.setPadding(new Insets(15, 12, 15, 12));
		menuGroupBckContact.setSpacing(10);
		mainChatUI = new BorderPane();
		
		/** Initials Label
		 *	Please not that this variable should
		 *	be instanciated with an actual contact name 
		 **/
		contactName = new Label("Andrew");
		contactName.getStyleClass().add("contact-label");
	}
	public void addChatComponentsToLayouts() {
		
		/*Add chat bubble to chat bubble scroll layout*/
		chatAreaLayout.setContent(chatBubbleLayout);
		/*Group buttons*/
		menuBtnGroup.getChildren().addAll(voiceBtn,videoBtn,createChatGroupBtn);//fileUploadBtn createChatGroupBtn
		messageMenuGroup.getChildren().addAll(fileUploadBtn,msgField,sendBtn);//fileUploadBtn, 
		menuGroupBckContact.getChildren().addAll(backBtn,contactName);
		menuGroup.getChildren().addAll(menuGroupBckContact,menuBtnGroup);           // Add to HBox from Example 1-2
	    HBox.setHgrow(menuBtnGroup, Priority.ALWAYS);
	    /*Add components and layouts to main layout*/
	    mainChatUI.setTop(menuGroup);
	    mainChatUI.setCenter(chatAreaLayout);
	    mainChatUI.setBottom(messageMenuGroup);
	    mainChatUI.getTop().setEffect(dropShadow);
	    /*Add UI to window*/
		this.chatScene = new Scene(mainChatUI, 420, 600);
		chatScene.getStylesheets().add(ClientUI.class.getResource("UI.css").toExternalForm());	
	}
	public void handleChatContacts(){
		/* *
		 * PLEASE PLACE ALL CODE INVOLVING FILES AND OR SERVER CALLS HERE
		 * */
	}
	public void loadMsg(String chatID){
		ArrayList<ChatHistory> chatMsgList = new ArrayList<ChatHistory>();
		chatMsgList = ChatHistory.getChatHistory(chatID);
		
		if(chatMsgList != null){
			System.out.println("message list count" + chatMsgList.size());
			msgCount = chatMsgList.size();
			for(int i = 0; i < chatMsgList.size(); i++){
				if(chatMsgList.get(i).getSender().equals(activeUser)){
					Label newMessage = new Label(chatMsgList.get(i).getMessage()+"\t\t\t\t"+chatMsgList.get(i).getTimeStamp());
					newMessage.setEffect(dropShadow);
					newMessage.setWrapText(true);
			        newMessage.getStyleClass().add("user-chat-bubble");
					chatBubbleLayout.addRow(i, newMessage);
					GridPane.setHalignment(newMessage, HPos.RIGHT);
				} else {
					Label newMessage = new Label(chatMsgList.get(i).getMessage()+"\t\t\t\t"+chatMsgList.get(i).getTimeStamp());
					newMessage.setEffect(dropShadow);
					newMessage.setWrapText(true);
			        newMessage.getStyleClass().add("contact-chat-bubble");
					chatBubbleLayout.addRow(i, newMessage);
					GridPane.setHalignment(newMessage, HPos.LEFT);
				}
			}
		}else {
			System.out.println("No chat History");
			
			/* ChatHistory newChatHistory = new ChatHistory(msgField.getText(), activeUser,contactName.getText().toString(),TimeStamp.getTimeStamp());
		     ArrayList<ChatHistory> chatHistory = ChatHistory.getChatHistory(contactName.getText().toString());
		      */  
		}
	}
	public void sendMsg(String msg){
		Label newMessage = new Label(msg+"\t\t\t\t"+TimeStamp.getTimeStamp());
		newMessage.setEffect(dropShadow);
		newMessage.setWrapText(true);
        newMessage.getStyleClass().add("user-chat-bubble");
        GridPane.setHalignment(newMessage, HPos.RIGHT);
        chatBubbleLayout.addRow(msgCount, newMessage);
        
        /*Save message to chat History*/
        @SuppressWarnings("unused")
		ArrayList<ChatHistory> chatHistoryList = new ArrayList<ChatHistory>();
        ArrayList<ChatHistory> chatHistory = new ArrayList<>();
        ArrayList<ChatHistory> tempChatHistory = new ArrayList<>();
        ChatHistory newChatHistory = new ChatHistory(msg, activeUser, contactName.getText().toString(),TimeStamp.getTimeStamp());
        
        tempChatHistory = ChatHistory.getChatHistory(contactName.getText().toString());
        if(tempChatHistory != null){
        	System.out.println("Append to history");
        	chatHistory = tempChatHistory;
        	chatHistory.add(newChatHistory);
        }
        else {
        	System.out.println("Chat history empty");
        	chatHistory.add(newChatHistory);
        }
        //System.out.println("Message1: " + chatHistoryList.get(0).getMessage());
        ChatHistory.saveChat(chatHistory, contactName.getText().toString(), newChatHistory);
                
	}
	public void lunchChatUI() {
		initializeChatComponents();
		addChatComponentsToLayouts();
	}
	/**
	 * APPLICATION LISTENERS 
	 **/
	public void registerListeners(){
		
        signInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	String uName = userTextField.getText().toString();
                String pWord = passwordField.getText().toString();
                if(!uName.equals("") && !pWord.equals("")){
                	AuthMsg msg = new AuthMsg(uName, pWord, TimeStamp.getTimeStamp(),true);
                	activeUser = uName;
                	msg.setRecipient("Server");
                	socket.sendSocket(msg);
                	applicationWindow.setTitle("Conectado - " + activeUser);
                }
                else{
                	System.out.println("Login Fail: " + uName + pWord);
                	actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Login Fail: The username or password can is incorrect");
                }
            }
        });
        signUpBtn.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
			public void handle(ActionEvent e) {
            	String uName = userTextField.getText().toString();
                String pWord = passwordField.getText().toString();
                if(!uName.equals("") && !pWord.equals("")){
                	AuthMsg msg = new AuthMsg("Signup", uName, pWord, TimeStamp.getTimeStamp(),true);
                	activeUser = uName;
                	msg.setRecipient("Server");
                	socket.sendSocket(msg);
                	applicationWindow.setTitle("Conectado- " + activeUser);
                }
                else{
                	System.out.println("Login Fail");
                	actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("The username is Andrew and the password is password");
                }
            	System.out.println("Event Trigger " + e.toString());
            }
        });
        
        contactListView.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Label>() {
				@Override
				public void changed(ObservableValue<? extends Label> observable, Label oldValue, Label newValue) {
					contactName.setText(newValue.getText());
                    System.out.println("Contact selected: "+ contactName.getText());
                    loadMsg(contactName.getText());
                    applicationWindow.setScene(chatScene);
				}
        });
        
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(!msgField.getText().isEmpty()){
					Message msg = new Message("Chat", activeUser, contactName.getText(), TimeStamp.getTimeStamp(), msgField.getText());
					socket.sendSocket(msg);
					sendMsg(msgField.getText());
					System.out.println("Message sent to: "+ contactName.getText());
					msgField.clear();
					msgCount++;
				} else {
					System.out.println("Empty Field: Message not sent");
				}
			}
		});
        backBtn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				//lunchLoginUI();
				lunchHomeUI();
				lunchChatUI();
				registerListeners();
				applicationWindow.setScene(homeScene);
			}
        });
		msgField.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
			public void handle(KeyEvent ke) {
		    	if (ke.getCode().equals(KeyCode.ENTER)) {
		    		if(!msgField.getText().isEmpty()){
						sendMsg(msgField.getText());
						msgField.clear();
						msgCount++;
		    		}
		    		
		    		System.out.println("Empty Field");
		    	}
		    }
		});

		/*msgField.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    public void handle(KeyEvent ke) {
		        System.out.println("Key Released: " + ke.getText());
		    }
		});*/
		final Stage primaryStage = null;
		videoBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                GridPane dialogVbox = new GridPane();
                dialogVbox.setAlignment(Pos.CENTER);
                dialogVbox.setHgap(10);
                dialogVbox.setVgap(10);
                dialogVbox.setPadding(new Insets(25, 25, 25, 25));
                dialogVbox.setStyle("-fx-background-color: #FF9966;");
                dialogVbox.getChildren().add(new Text("This is for video call"));
                Scene dialogScene = new Scene(dialogVbox, 300, 100);
                dialog.setScene(dialogScene);
                dialog.show();
			}
		});
		voiceBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                GridPane dialogVbox = new GridPane();
                dialogVbox.setAlignment(Pos.CENTER);
                dialogVbox.setHgap(10);
                dialogVbox.setVgap(10);
                dialogVbox.setPadding(new Insets(25, 25, 25, 25));
                dialogVbox.setStyle("-fx-background-color: #FF9966;");
                dialogVbox.getChildren().add(new Text("This is for voice call"));
                Scene dialogScene = new Scene(dialogVbox, 300, 100);
                dialog.setScene(dialogScene);
                dialog.show();
			}
		});
	}

	public Label getUserName() {
		return userName;
	}

	public void setUserName(Label userName) {
		this.userName = userName;
	}

	public JFXTextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(JFXTextField userTextField) {
		this.userTextField = userTextField;
	}

	public JFXPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JFXPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public Scene getLoginScene() {
		return loginScene;
	}

	public void setLoginScene(Scene loginScene) {
		this.loginScene = loginScene;
	}

	public HBox getMainHomeUI() {
		return mainHomeUI;
	}

	public void setMainHomeUI(HBox mainHomeUI) {
		this.mainHomeUI = mainHomeUI;
	}

	public JFXListView<Label> getContactListView() {
		return contactListView;
	}

	public void setContactListView(JFXListView<Label> contactListView) {
		this.contactListView = contactListView;
	}

	public JFXListView<Label> getMessageListView() {
		return messageListView;
	}

	public void setMessageListView(JFXListView<Label> messageListView) {
		this.messageListView = messageListView;
	}

	public Label[] getContactList() {
		return contactList;
	}

	public void setContactList(Label[] contactList) {
		this.contactList = contactList;
	}

	public Label[] getMessageList() {
		return messageList;
	}

	public void setMessageList(Label[] messageList) {
		this.messageList = messageList;
	}

	public Scene getHomeScene() {
		return homeScene;
	}

	public void setHomeScene(Scene homeScene) {
		this.homeScene = homeScene;
	}

	public JFXTextField getMsgField() {
		return msgField;
	}

	public void setMsgField(JFXTextField msgField) {
		this.msgField = msgField;
	}

	public Label getContactName() {
		return contactName;
	}

	public void setContactName(Label contactName) {
		this.contactName = contactName;
	}

	public Label getUserChatBubble() {
		return userChatBubble;
	}

	public void setUserChatBubble(Label userChatBubble) {
		this.userChatBubble = userChatBubble;
	}

	public Label getContactChatBubble() {
		return contactChatBubble;
	}

	public void setContactChatBubble(Label contactChatBubble) {
		this.contactChatBubble = contactChatBubble;
	}

	public BorderPane getMainChatUI() {
		return mainChatUI;
	}

	public void setMainChatUI(BorderPane mainChatUI) {
		this.mainChatUI = mainChatUI;
	}

	public Scene getChatScene() {
		return chatScene;
	}

	public void setChatScene(Scene chatScene) {
		this.chatScene = chatScene;
	}

	public int getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public String getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}

	public ClientSocket getSocket() {
		return socket;
	}

	public void setSocket(ClientSocket socket) {
		this.socket = socket;
	}

	public Stage getApplicationWindow() {
		return applicationWindow;
	}

	public void setApplicationWindow(Stage applicationWindow) {
		this.applicationWindow = applicationWindow;
	}

	public Text getSceneTitle() {
		return sceneTitle;
	}

	public void setSceneTitle(Text sceneTitle) {
		this.sceneTitle = sceneTitle;
	}
	
}


