package Services;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.DateTimeAtCreation;

public class OperationValidation {

	//email validation
		public static boolean isValiEmail(String email) {
			
			//email validate rules
			final String email_Rule="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*(\\\\.[a-zA-Z]{2,7})$";
			
			//compile email rule using pattern type variable
			Pattern patern=Pattern.compile(email_Rule);
			
			//match the user entered mail with pattern
			Matcher match=patern.matcher(email);
			
			return match.matches();
		}
		
		
}
