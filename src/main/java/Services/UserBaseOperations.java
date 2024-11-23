package Services;

import java.sql.Connection;

public abstract class UserBaseOperations {

	//Validate() method as abstract, the actual implementation can vary between different subclasses
	//Polymorphism: Different subclasses provide different implementations of the Validate()
	public abstract boolean Validate(String UserName, String Password);
}
