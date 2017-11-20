import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.RemoteException;



public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {

        try {
            RmiInterface stub = new RmiImplementation();
            Naming.rebind("server", stub);
            System.out.println("Server Started: 6060");
        }
        catch(Exception e)
        {
            System.out.println("An exception occured");
        }
    }
}
