/**
 * multibinaryclient.java
 * Requests files and they are sent back in bytes
 * 
 * @author Arielle Davenport
 * 
 * Last modified: 5-9-15
 */
import java.util.*;
import java.net.*;


public class multibinaryclient{
	
	public static void main(String[] args){
		//check to see if array is empty, if so they need to put correct information
		if(args.length == 0){
			System.out.println("Usage:");
			System.out.println("java multibinaryclient <server> <port>");
		}
		Socket client_socket;
		//get the host address and port number given in directions
		InetAddress hostname;
		int portnum;
		String filename = null;
		 //standard output to read file name
		Scanner in = new Scanner(System.in);
		
		//now scan file for file names
		 try
		 {
			hostname = InetAddress.getByName(args[0]);
			portnum = Integer.valueOf(args[1]).intValue();
			
			while(in.hasNextLine()){
				filename = in.nextLine();
				client_socket = new Socket(hostname, portnum);
				
				//start reading bytes in file
				//start with object
				MakeThread m1 = new MakeThread(filename,client_socket);
				//run object in thread
				Thread t1 = new Thread(m1);
				t1.start();
				
				
			}
			
		 }
		 catch(Exception e){

			//do nothing
		 }
	}

}
