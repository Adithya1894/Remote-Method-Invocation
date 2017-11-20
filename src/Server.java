import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;


public class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {
        RmiImplementation stub = new RmiImplementation();
        Naming.rebind("Implementation", stub);
        System.out.println("Server Started: 6060");

    }
}
