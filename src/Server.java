import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * Server class, where the Binding happens
 */
public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {

        //System.setSecurityManager(new SecurityManager());

        try {
            /**
             * Binding the Server with the functionality present at the server
             */

            //Registry register= LocateRegistry.createRegistry(5050);
            //RmiInterface stub = new RmiImplementation();
            String name = "server";
            RmiImplementation stub = new RmiImplementation(name);

            Naming.rebind(name, stub);

            System.out.println("Server Started");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
