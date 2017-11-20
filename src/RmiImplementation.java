import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface{

    /**
     * Constructor for the RmiImplementaion class
     * @throws RemoteException
     */
    public RmiImplementation() throws RemoteException{
        super();

    }

    /**
     * overriding the echo method of the RmiInterface Method
     * gets the input from the user and sends the response back
     * @param input Takes the user input as argument
     * @return
     * @throws RemoteException
     */
    @Override
    public String echo(String input) throws RemoteException {
        System.out.println("Echo Method called");
        System.out.println("Response sent to the client is: "+input);
        return input;
    }

    /**
     * gets the input from the client and sorts the list and sends it back to client
     * @param list_input Array of integers
     * @return
     * @throws RemoteException
     */
    @Override
    public int[] sort_list(int[] list_input, int size) throws RemoteException {

        for(int i = 0; i < size; i++)
        {


                int key = list_input[i];
                int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j>=0 && list_input[j] > key)
                {
                    list_input[j+1] = list_input[j];
                    j = j-1;
                }
                list_input[j+1] = key;

        }


        return list_input;
    }

    /**
     * finds the current working directory of the server and sends it back to the client
     * @return
     * @throws RemoteException
     */
    @Override
    public String pwd() throws RemoteException {

        String pwd;
        System.out.println("Path Method Called");
        //Path path = FileSystems.getDefault().getPath(".");

        Path path_pwd = Paths.get("");
        pwd = path_pwd.toAbsolutePath().toString();
        System.out.println("Directory: " +pwd);
        return pwd;
    }

    /**
     * Checks if a file is present in the Directory and returns a boolean
     * @param file_name, the file which you want to check
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean file_check(String file_name) throws RemoteException {
        return false;
    }
}
