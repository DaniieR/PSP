package tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteMensajeArchivo {
	public static void main (String[ ] args) throws InterruptedException {
		 try {
			 System.out.println("Creando socket cliente");
			 Socket clientSocket;			 
			 do{
				 clientSocket = new Socket(); 
				 try {											 
					 System.out.println("Estableciendo la conexión");
					 InetSocketAddress addr = new InetSocketAddress("localhost",5555);
					 clientSocket.connect(addr);					 
				} catch (Exception e) {					
					
					System.out.println("No se ha podido conectar al servidor");
					Thread.sleep(3000);					
				}
				 
			 }while((!clientSocket.isConnected()));	 
			 		 
			 InputStream is = clientSocket.getInputStream();	
			 byte[] mensaje = new byte[10000];			 
			 String linea ;			 
			 InputStreamReader isr = new InputStreamReader(is);
			 BufferedReader br = new BufferedReader(isr);			
			 System.out.println("Cerrando el socket cliente");
			 clientSocket.close();			 
			 System.out.println("Terminado");
			 
		 } catch (IOException e) {
			 e.printStackTrace();
		 }		 
	}
}
