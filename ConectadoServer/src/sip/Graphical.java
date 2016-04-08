package sip;

import java.util.Vector;

import java.util.Vector;

import org.zoolu.sip.address.NameAddress;
import org.zoolu.sip.provider.SipProvider;
import org.zoolu.tools.Log;

//import local.ua.StringList;
import local.ua.UserAgent;
import local.ua.UserAgentListener;
import local.ua.UserAgentProfile;

public class Graphical implements UserAgentListener{
	String appname;
	Log log;
	SipProvider sip_providor; 
	UserAgent ua;
	UserAgentProfile ua_profile;
	int NMAX_CONTACTS=10;
	//StringList friends_list;
	
	

	@Override
	public void onUaCallAccepted(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallCancelled(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallClosed(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallFailed(UserAgent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallProgress(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallRinging(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaCallTransferred(UserAgent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaIncomingCall(UserAgent arg0, NameAddress arg1, NameAddress arg2, @SuppressWarnings("rawtypes") Vector arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaMediaSessionStarted(UserAgent arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaMediaSessionStopped(UserAgent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaRegistrationFailed(UserAgent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUaRegistrationSucceeded(UserAgent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
