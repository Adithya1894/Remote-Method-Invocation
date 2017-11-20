import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {

        String val;


        try {
            RmiInterface obj = (RmiInterface) Naming.lookup("server");
            int i = 0;
            while( i < 10)
            {

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the input: \n");
                val = sc.nextLine();

                String result = obj.echo(val);
                System.out.println("result from the server is: " + result);
                i++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception occured");
        }


    }
}
