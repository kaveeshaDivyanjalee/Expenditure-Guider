package Services;

public class ConfirmationMessage {

	public String getMessage(String messageType) {
		
		switch(messageType) {
		case "delete":
			return "You have Cancel your reserved tour Successfully";
		case "update":
			return "You have Update your reserved tour Successfully";
		default:
			return "Operation completed Successfully";
		}
		
	}
}
