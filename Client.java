import java.net.*;
import java.io.*;

public class Client{
    //initializing the socket and inut/output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    //constructor to put IP address and port
    public Client(String address, int port){
        //estalish a connection
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");

            //takes input from termial
            input = new DataInputStream(System.in);

            //send output to the socket
            out = new DataOutputStream(socket.getOutputStream());
            
        }
        catch(UnknownHostException u){
            System.out.println(u);

        }
        catch(IOException i){
            System.out.println(i);
        }

        //read from input
        String line ="";
        
        //read until the end
        while(!line.equals("End")){
            try{
                line = input.readLine();
                out.writeUTF(line);

            }
            catch(IOException i){
                System.out.println(i);
            }
        }

        //close connection
        try{
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i){
            System.out.println(i);
        }
        
}
public static void main(String[] args) {
    Client client = new Client("127.0.0.1", 5000);
}
}