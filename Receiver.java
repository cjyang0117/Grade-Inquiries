import java.io.*;
import java.net.*;

public class Receiver { 
byte[] data;
DatagramPacket pack;
DatagramSocket ds;
public Receiver(int port) 
	{
     try{	
         data = new byte[50];		
         pack = new DatagramPacket(data, data.length);
         ds = new DatagramSocket(port);
      }
     catch(IOException e){
         System.out.println("IOException when connecting Server!"); 
      }
   }
   
public String receive() throws IOException
 {
         ds.receive(pack); // Programs stop here and wait for receiving
         String str = new String(data);
		 return str;
 }   

}
