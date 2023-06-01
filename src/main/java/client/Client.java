package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

import entity.Customer;

public class Client {
	public static void main(String[] args) {
		
		try(
//				Socket socket = new Socket("H91M30", 4568);
				Socket socket = new Socket("192.168.1.2", 4568);
				Scanner sc = new Scanner(System.in);
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				){
			
			while(true) {
				System.out.println("Enter customer id to find:");
				int customerId = sc.nextInt();
				out.writeInt(customerId);
				
				Object o = in.readObject();
				if(o instanceof Customer) {
					Customer customer = (Customer) o;
					System.out.println(customer);
				}else
					System.out.println(o.toString());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
