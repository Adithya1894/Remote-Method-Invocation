import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {

    String Echo(String input) throws RemoteException;

    
}
