package Trabajo;

import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class classClient {
	public static void main(String[] args) {
		try {

			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();

			String ip = "192.168.26.14";

			InetSocketAddress address = new InetSocketAddress(ip, 5555);
			clientSocket.connect(address);

			ObjectOutputStream objectOS = new ObjectOutputStream(clientSocket.getOutputStream());
			System.out.println("Enviando mensaje");
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el Codigo");
			int codigo = Integer.parseInt(sc.nextLine());
			System.out.println("Nombre de Usuario");
			String userName = sc.nextLine();
			System.out.println("Escribe tu mensaje");
			String userMessage = sc.nextLine();
			
			
			Mensaje miObjeto = new Mensaje(codigo, userName,userMessage);
			
			System.out.println(miObjeto.getCodigo());
			System.out.println(miObjeto.getMensaje());
			System.out.println(miObjeto.getUsuario());
			
			objectOS.writeObject(miObjeto);
			
			System.out.println("Mensaje enviado");
			clientSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}