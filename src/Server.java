import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * Server class, where the Binding happens
 */
public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {


/**
             * Binding the Server with the functionality present at the server
             */


            //System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Server!");
			
			// Location of Server
			String name = "//127.0.0.1:2012/server";
			
			System.out.println("Server: Binding it to name: " + name);
			
                        
                        
                        RmiInterface assignment = (RmiInterface)Proxy.newProxyInstance(RmiInterface.class.getClassLoader(),
	                new Class<?>[] {RmiInterface.class},
	                new AuthorizationInvocationHandler(new RmiImplementation()));

//			RmiInterface assignment = (RmiInterface)Proxy.newProxyInstance(RmiInterface.class.getClassLoader(),
//	                new Class<?>[] {RmiInterface.class},
//	                new AuthorizationInvocationHandler(new RmiImplementation()));
//						
			// Binds the Server to the RMI Service.
			Naming.rebind(name, assignment);
			
			System.out.println("Server Ready!");
		}            
            
            
            
//            String name = "server";
//            RmiImplementation stub = new RmiImplementation(name);
//
//            Naming.rebind(name, stub);
//
//            System.out.println("Server Started");
//        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
