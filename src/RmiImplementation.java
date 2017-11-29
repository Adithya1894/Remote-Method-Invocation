import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface{

    /**
     * Constructor for the RmiImplementaion class
     * @throws RemoteException
     */
    private float value = 10000;
    private int id;
    private String name;
    public RmiImplementation(String s) throws RemoteException{
        super();
        name = s;

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

            /**
             * Insertion sort logic
             */
            int key = list_input[i];
                int j = i-1;

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

        //using the Path class to get the present working directory
        Path path_pwd = Paths.get("");

        //Changing the path to a string
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


        File input_file = new File(file_name);

        System.out.println("File_Check called");

        if(input_file.exists()) {

            return true;
        }
        return false;




    }

    /**
     *
     * @param matrix1
     * @param matrix2
     * @param dimension
     * @return
     * @throws RemoteException
     */
    @Override
    public int[][] matrix_multiplication(int[][] matrix1, int[][] matrix2, int dimension) throws RemoteException {


        int [][] result = new int[1000][1000];


        System.out.println("Matrix Multiplication called");
        int i, j, k;
        for (i = 0; i < dimension; i++)
        {
            for (j = 0; j < dimension; j++)
            {
                result[i][j] = 0;
                for (k = 0; k < dimension; k++)
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
            }
        }

        //returning the two dimensional array
        return result;
    }




}
