import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {

    String echo(String input) throws RemoteException;

    /**
     * Metohd to sort the list elements, takes the input as an array
     * @param list_input
     * @return
     * @throws RemoteException
     */
    int[] sort_list(int[] list_input) throws RemoteException;
}
