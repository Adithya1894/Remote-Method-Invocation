# Remote-Method-Invocation
A Distributed Client-Server Application using Remote Method Invocation



# Running the Application

IMPORTANT  

open a pegasus Terminal Window - 10.234.136.57(only the Rmiregistry on this server)  
 
go to the src directory use the command cd src    
compile all the java files and Run the RMIRegistry using the Command sh Makefile_Registry.sh   
once this compiles and the RmiRegistry starts succesfully, the cursor just stays there.   
you can carryon with other steps in a new terminal window of the same server.   


# Running Client and Server   

IMPORTANT  
  
Now open another window of the  same Pegasus Terminal   
RMiRegistry and server files should be run on same Server.  
10.234.136.57  
The program will not run on other systems  
  


Go to the src Directory Again  use the command cd src   
use the command sh Makefile_Server.sh to start the server  

To Run the Client, open another any other pegasus Terminal window    
Go to the src Directory Again use the command cd src    
use the command sh Makefile_Client.sh (This will start the Client)    

After compiling the client and server just follow the onscreen instructions    
