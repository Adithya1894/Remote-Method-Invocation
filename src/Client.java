import java.net.MalformedURLException;
import java.nio.file.Path;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
   static RmiInterface obj;

    /**
     * Echos the input taken from the user.
     */
    public void client_echo(){

        String val;
        Scanner sc = new Scanner(System.in);

        val = sc.nextLine();

        String result;
        try {
            result = obj.echo(val);
            System.out.println("result from the server is: " + result);
        } catch (RemoteException e) {
            System.out.println("Exception occured while Echo");
        }

    }


    /**
     * Takes a list of integers and outputs the sorted list
     */
    public void client_sort(){

        int [] arr = new int[1000];

    }

    /**
     * Prints the present working directory of the server.
     */
    public void client_pwd(){

        String pwd;
        try{

            pwd = obj.pwd();

            System.out.println("\n Present working directory is: \n");

            System.out.println(pwd);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured in printing the directory");
        }


    }

    /**
     * Checks if the file is present and prints the message accordingly
     */
    public void client_file_check(){


    }

    /**
     * Method to multiply two matrices
     */
    public void client_matrix_multiplication(){

    }

    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {


        try {
             obj = (RmiInterface) Naming.lookup("server");

             Client client_obj = new Client();

             int i = 0;


            while(i!=6){

                System.out.println("Menu\n");
                System.out.println("1. Echo the input");
                System.out.println("2. Sort the List");
                System.out.println("3. Print the Present directory");
                System.out.println("4. Check if a file is available");
                System.out.println("5. Matrix Multiplication");
                System.out.println("Please choose an option: \n");
                Scanner sc = new Scanner(System.in);

                i = sc.nextInt();

                switch (i)
                {
                    case 1: client_obj.client_echo();
                    break;

                    case 2: client_obj.client_sort();
                    break;

                    case 3: client_obj.client_pwd();
                    break;

                    case 4: client_obj.client_file_check();
                    break;

                    case 5: client_obj.client_matrix_multiplication();
                    break;

                    default:System.out.println("Please choose a valid option");

                }
            }

        }
        catch (Exception e)
        {
            System.out.println("Exception occured");
        }




    }
}
