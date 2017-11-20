import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface{


    public RmiImplementation() throws RemoteException{
        super();

    }
    @Override
    public String echo(String input) throws RemoteException {
        System.out.println("Echo Method called");
        System.out.println("Response sent to the client is: "+input);
        return input;
    }

    @Override
    public int[] sort_list(int[] list_input) throws RemoteException {
        return new int[0];
    }

    @Override
    public String pwd() throws RemoteException {
        return null;
    }

    @Override
    public String file_check(String file_name) throws RemoteException {
        return null;
    }
}
