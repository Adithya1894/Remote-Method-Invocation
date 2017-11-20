import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {
    /**
     * Method to Echo the input sent by the user
     * @param input Takes the user input as argument
     * @return returns a string which is same as the input sent by the user
     * @throws RemoteException
     */
    String echo(String input) throws RemoteException;

    /**
     * Metohd to sort the list elements, takes the input as an array
     * @param list_input Array of integers
     * @return the sorted list
     * @throws RemoteException
     */
    int[] sort_list(int[] list_input,int size) throws RemoteException;

    /**
     * Returns the current working directory of the server
     * @return
     * @throws RemoteException when the method receives an error from the server
     */
    String pwd() throws RemoteException;

    /**
     * Checks if the entered filename is present at the server
     * @param file_name, the file which you want to check
     * @return true if the searched file is present, if not False
     * @throws RemoteException when the method receives an Exception instead of result
     */
    boolean file_check(String file_name) throws RemoteException;

    /**
     * Method for Matrix Multiplication, takes the input values of two matrices
     * Returns the Multiplied Matrix value
     * @param matrix1
     * @param matrix2
     * @param dimension
     * @return
     * @throws RemoteException
     */
    int[][] matrix_multiplication(int[][] matrix1, int[][] matrix2, int dimension) throws RemoteException;





}
