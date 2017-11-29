import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * Server class, where the Binding happens
 */
public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {



        try {
            /**
             * Binding the Server with the functionality present at the server
             */


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
