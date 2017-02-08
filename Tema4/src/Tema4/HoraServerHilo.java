package Tema4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class HoraServerHilo extends Thread {
	private Socket clientSocket;
	
	public HoraServerHilo (Socket socket){
		clientSocket=socket;
	}
	
	public void run(){
		try {
			System.out.println("Arrancando Hilo");
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();
			System.out.println("Esperando mensajes");
			byte[] buffer = new byte[4];
			inputStream.read(buffer);
			String peticion = new String(buffer);
			System.out.println("Peticion recibida");
			if (peticion.equals("hora")) {
				System.out.println("Enviando respuesta");
				Date d = new Date(System.currentTimeMillis());
				byte[] respuesta = d.toString().substring(11,23).getBytes();
				outputStream.write(respuesta);
				System.out.println("Mensaje enviado");
			} else if (peticion.equals("fech")) {
				System.out.println("Enviando respuesta");
				Date d = new Date(System.currentTimeMillis());
				byte[] respuesta = (d.toString().substring(0,11)+d.toString().substring(24)).getBytes();
				outputStream.write(respuesta);
				System.out.println("Mensaje enviado");
			}else {
				System.out.println("Mensaje recibido no reconocido");
			}
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Hilo terminado");
	}
	public static void main (String[] args){
		System.out.println("Crando socket servidor");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress address = new InetSocketAddress("192.168.26.109", 5555);
			serverSocket.bind(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Aceptando conexiones");
		while (serverSocket!=null){
			try {
				Socket newSocket = serverSocket.accept();
				System.out.println("Conexion recibida");
				HoraServerHilo hilo = new HoraServerHilo(newSocket);
				hilo.start();
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		System.out.println("Terminado");
	}
}
