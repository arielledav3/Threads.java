/**
 * MakeThread.java
 * main file for thread and bytes
 * 
 * @author Arielle Davenport
 * 
 * Last modified: 5-9-15
 */
import java.io.*;
import java.net.*;


public class MakeThread implements Runnable {
	String filename;
	Socket client_socket;
	//constructor
	public MakeThread(String file, Socket cl_socket){
		//takes constructor for file that needs to have bytes read and the client side socket
		filename = file;
		client_socket = cl_socket;
	}
	
	//needs run method for thread and running file transfer each time                                                                                                                    ONMOOONM
	public void run(){
		try{
			//declare long int for reading bytes
			long bytelong = 0; 
			
			DataOutputStream output = new DataOutputStream(client_socket.getOutputStream());
			DataInputStream input = new DataInputStream(client_socket.getInputStream());
			
			output.writeUTF(filename);
			//read long bytes
			 bytelong = input.readLong();
			 System.out.println("Recieved: " + bytelong);
			
			//if long is not zero
			if(bytelong != 0){
				byte[] files = new byte[(int) bytelong];
				
				for(long i = 0; i < bytelong; i++){
					
					files[(int)i] = input.readByte();
				}
					
				//take file received and store locally with same name
				FileOutputStream f = new FileOutputStream(filename);
				//write same name and close the file. 
				f.write(files);
				f.close();
			}
			System.out.println("Shutting down");
			client_socket.close();	
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}	

}
