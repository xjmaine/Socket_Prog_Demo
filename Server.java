import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    //constructor with port
    public Server(int port) {
        //starts server and waits for a connection
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client...");

            socket = server.accept();
            System.out.println("Client accepted the connection");

            //accept input from client
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            String line = "";

            //read message from client
            while(!line.equals("End")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }

                catch(IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection...");

            //close all connections
            socket.close();
            in.close();
        }
        catch( IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
