package Model;

public class LogedUserSession {
	
		private String userName;
	    private int userId;

	    public LogedUserSession(String userName, int userId) {
	        this.userName = userName;
	        this.userId = userId;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    
	
}
