package tema3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

class HiloSocket extends Thread{
	public static String mensaje="";
	Socket socket;
	
	public HiloSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] mensaje = new byte[25];
			is.read(mensaje);
			System.out.println("Mensaje recibido:" + mensaje.toString());
			HiloSocket.mensaje=mensaje.toString();
			System.out.println("Cerrando el nuevo socket");
			socket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
}


public class ServidorSocketStream {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);
			
			//int contador = 0;
			while(HiloSocket.mensaje!="Cierrate" || HiloSocket.mensaje!="cierrate"){
				
			System.out.println("Aceptando conexiones");
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexión recibida");
			new HiloSocket(newSocket).start(); 
			
			}
			
			System.out.println("Cerrando el socket servidor");
			serverSocket.close();
			System.out.println("Terminado");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
}