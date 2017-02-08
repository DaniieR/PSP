package Trabajo;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import Trabajo.Mensaje;

public class ServerMensaje extends Thread {
	private Socket clientSocket;

	public ServerMensaje(Socket socket) {
		this.clientSocket = socket;
	}

	public void run() {
		// Lo que va a hacer cada hilo
		try {
			System.out.println("Arrancando hilo");
			//Inicio del bucle para no parar de recibir mensajes
			ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			kk miObjeto = new kk();
			System.out.println("Esperando Mensaje");
			try {
				miObjeto = (kk) objectInputStream.readObject();
				System.out.println("Mensaje Recibido Codigo:"+miObjeto.getCodigo()+" , Usuario: "+miObjeto.getUsuario()+", y el mensaje es: "+miObjeto.getMensaje());

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//fin del bucle
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		System.out.println("Creando socket servidor");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("192.168.26.109", 5555);
			serverSocket.bind(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Aceptando Conexiones");
		while (serverSocket != null) {
			try {
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexion recibida");
				ServerMensaje hilo = new ServerMensaje(newSocket);
				hilo.start();
				System.out.println("Terminado");
				serverSocket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}