package Model;

public class Schedule {

	private String scheduleID;
	private String date;
	private boolean isAvailable;
	private String guideID;
	
	public Schedule(String scheduleID,String date,boolean isAvailable,String guideID) {
		
		this.scheduleID=scheduleID;
		this.date=date;
		this.isAvailable=isAvailable;
		this.guideID=guideID;
	}

	public String getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getGuideID() {
		return guideID;
	}

	public void setGuideID(String guideID) {
		this.guideID = guideID;
	}
	
	
}
