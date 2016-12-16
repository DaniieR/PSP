package tema3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocketStream {
	public static void main(String[] args) {
		int contador=0;
		String mensaje="";
		while(mensaje.compareTo("Cierrate")==0){
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			//String ip="192.168.26.166";
			InetSocketAddress addr = new InetSocketAddress(/*InetAddress.getByName(ip)*/"localhost", 5555);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			System.out.println("Enviando mensaje");
			Scanner tcl=new Scanner(System.in);
			mensaje = tcl.nextLine();
			os.write(mensaje.getBytes());
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		contador++;
	}
	}
}