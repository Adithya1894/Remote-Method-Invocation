import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {

        String val = "Hello";

        RmiInterface obj = (RmiInterface) Naming.lookup("server");

        String result = obj.echo(val);

        System.out.println("result from the server is: " + result);



    }
}
