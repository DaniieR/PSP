package Tema4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FechaClientHilo {
	public static void main (String[] args){
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexion");
			
			InetSocketAddress address = new InetSocketAddress("192.168.26.109", 5555);
			clientSocket.connect(address);
			
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();
			System.out.println("Enviando peticion de Hora");
			outputStream.write("fech".getBytes());			
			BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println("Recibiendo resultado");
			String mensaje;
			mensaje = entradaEstandar.readLine();
			System.out.println("El resultado es: "+mensaje);
			clientSocket.close();
			System.out.println("Terminado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
