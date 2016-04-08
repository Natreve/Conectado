package socket;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStamp {
	public static String getTimeStamp(){
		Calendar cal = Calendar.getInstance();
		String timeStamp;
		timeStamp = 
				new SimpleDateFormat("E").format(cal.getTime())+","+
				new SimpleDateFormat("h").format(cal.getTime())+":"+
				new SimpleDateFormat("m").format(cal.getTime())+
				new SimpleDateFormat("a").format(cal.getTime());
		return timeStamp;
	}
}
