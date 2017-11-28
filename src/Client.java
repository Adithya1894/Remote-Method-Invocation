import java.net.MalformedURLException;
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
        int size;

        int [] arr = new int[1000];
        int [] sorted_arr;


        System.out.println("Please enter the size of the list: \n");

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for(int i = 0; i < size;i++) {

            System.out.println("Enter the value of list item " + i);

            arr[i] = sc.nextInt();

        }

        try {
            sorted_arr = obj.sort_list(arr, size);
            System.out.println("Sorted array is: ");
            for(int i =0; i < size; i++){
                System.out.println(sorted_arr[i]);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }


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

        String file_name;



        System.out.println("Please enter the filename: \n");

        Scanner sc = new Scanner(System.in);

        file_name = sc.nextLine();

        try {
            if(obj.file_check(file_name))
            {
                System.out.println(file_name+ " is present at the server");
            }
            else
            System.out.println(file_name +" is not present at the server");
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    /**
     * Method to multiply two matrices
     */
    public void client_matrix_multiplication(){

        int[][] matrix1 = new int[1000][1000];
        int[][] matrix2 = new int[1000][1000];
        int[][] result = new int[1000][1000];
        System.out.println("Please enter the dimension of the matrix");

        Scanner sc = new Scanner(System.in);

        int dimension = sc.nextInt();


        //getting the first matrix values
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++)
            {
                System.out.println("Please enter the " +matrix1[i][j]+ " element: \n");

                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Please enter the elements for matrix 2");
        //getting the second matrix values
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++)
            {
                System.out.println("Please enter the " +matrix2[i][j]+ " element: \n");

                matrix2[i][j] = sc.nextInt();
            }
        }

        //calling the serverSide function of Matrix_Multiplication
        //try catch to catch any RemoteExceptions
        try {
           result = obj.matrix_multiplication(matrix1,matrix2,dimension);
           System.out.println("Multiplied Result:\n");
            for(int i = 0; i < dimension; i++){
                for(int j = 0; j < dimension; j++)
                {
                    //System.out.println("Please enter the " +matrix2[i][j]+ "element: \n");

                    System.out.print(result[i][j]+"\t");
                }
                System.out.println();
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {


        try {
             obj = (RmiInterface) Naming.lookup("server");

             Client client_obj = new Client();

             int i = 0;

            /**
             * Program exits when the option is 6
             */
            while(i!=6){

                System.out.println("Menu\n");
                System.out.println("1. Echo the input");
                System.out.println("2. Sort the List");
                System.out.println("3. Print the Present directory");
                System.out.println("4. Check if a file is available");
                System.out.println("5. Matrix Multiplication");
                System.out.println("6. Exit");
                System.out.println("Please choose an option: \n");
                Scanner sc = new Scanner(System.in);

                /**
                 * getting the input for i
                 */
                i = sc.nextInt();


                //Will be changing this switch case to Strategy Design Pattern.
                switch (i)
                {
                    case 1: {
                        Long var = System.nanoTime();
                        client_obj.client_echo();
                        Long var1 = System.nanoTime();
                        System.out.println("Round trip time in nanoSeconds is: " +(var1-var));
                        break;
                    }

                    case 2: {
                        Long var = System.nanoTime();
                        client_obj.client_sort();
                        Long var1 = System.nanoTime();
                         System.out.println("Round trip time in nanoSeconds is: " +(var1-var));
                        break;
                    }

                    case 3: {
                        Long var = System.nanoTime();
                        client_obj.client_pwd();
                        Long var1 = System.nanoTime();
                        System.out.println("Round trip time in nanoSeconds is: " +(var1-var));
                        break;
                    }

                    case 4: {
                        Long var = System.nanoTime();
                        client_obj.client_file_check();
                        Long var1 = System.nanoTime();
                        System.out.println("Round trip time in nanoSeconds is: " +(var1-var));
                        break;
                    }

                    case 5: {
                        Long var = System.nanoTime();
                        client_obj.client_matrix_multiplication();
                        Long var1 = System.nanoTime();
                        System.out.println("Round trip time in nanoSeconds is: " +(var1-var));
                        break;
                    }


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
