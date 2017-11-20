import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.RemoteException;



public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {
        RmiImplementation stub = new RmiImplementation();
        Naming.rebind("server", stub);
        System.out.println("Server Started: 6060");

    }
}
