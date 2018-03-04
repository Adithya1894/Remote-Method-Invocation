import java.io.Serializable;

public class UserRoleCreate implements Serializable{

	// This class is used to get the role for particular session 
	/**
	 * 
	 */
	//private static final long serialVersionUID = -1314398131941970330L;
	
	private String userRole;
	
	//This is the constructor of UserRoleCreate class
	public UserRoleCreate(String userRole)
	{
		//Assigning the value of userRole to the private variable
		this.userRole=userRole;
	}
	
	public String getRoleType(){
		
		//Returning the userRole requested
		return userRole;
	}
}
