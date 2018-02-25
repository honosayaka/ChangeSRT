package cn.honosayaka.jt;

public class Change {
	
	
	
	public static String[] devideString(String s) {
		String[] theDevided = {s.substring(0, 8),s.substring(9, 12),
				s.substring(17, 25),s.substring(26, 29)};
		return theDevided;
	}
	
	public static int timeStringToTimeInt(String timeString) {
		String[] times = timeString.split(":");
		return Integer.valueOf(times[0])*3600 +
				Integer.valueOf(times[1])*60 + 
				Integer.valueOf(times[2])-31;
	}
	
	public static String timeIntToTimeString(int timeInt) {
		StringBuilder timeString = new StringBuilder();
		int h = timeInt/3600;
		int m = (timeInt-h*3600)/60;
		int s = (timeInt-h*3600)%60;
		timeString.append(isDouble(h)+":");
		timeString.append(isDouble(m)+":");
		timeString.append(isDouble(s));
		return timeString.toString();
	}
	public static String isDouble(int number) {
		String tempTime = String.valueOf(number);
		if(tempTime.length()==1) {
			return "0"+number;
		}else {
			return tempTime;
		}
	}
	public static String changeTime(String timeString) {
		String[] theDevided = devideString(timeString);
		return timeIntToTimeString(timeStringToTimeInt(theDevided[0])) +
				","+ theDevided[1]+" --> " + 
				timeIntToTimeString(timeStringToTimeInt(theDevided[2]))+","+theDevided[3];
	}
	
	
}
