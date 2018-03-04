import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Session implements Serializable{

	// This class is used to create the session for the User with defined role.
	/**
	 * 
	 */
	//private static final long serialVersionUID = 7174130228932689043L;
	
	private UserRoleCreate user;
	
	//Constructor of the class SessionDefine which will set the user type.
	public Session(String userRole)
	{
		//Defining the role of the user 
		this.user=new UserRoleCreate(userRole);
	}

	//Method is used to get the user data;
	public UserRoleCreate getUser() {
		// TODO Auto-generated method stub
		return user;
	}


	
	
	
	

	
}
