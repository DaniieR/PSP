package tema3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio6 {
	public static void main(String[] args) {
		HiloServerJ6 hiloServerJ6 = new HiloServerJ6();
		hiloServerJ6.start();
		HiloClienteJ6 hiloClienteJ6 = new HiloClienteJ6();
		hiloClienteJ6.start();
	}
}

class HiloServerJ6 extends Thread {
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("192.168.26.169", 60000);
			serverSocket.bind(addr);
			System.out.println("Aceptando Conexiones");
			Socket newSocket = serverSocket.accept();
			System.out.println("Cliente conectado");
			while (true) {

			}
		} catch (IOException e) {
		}
	}
}

class HiloClienteJ6 extends Thread {
	public void run() {
		Socket clienteSocket;
		do {
			clienteSocket = new Socket();
			try {				
				InetSocketAddress address = new InetSocketAddress("192.168.26.161", 60000);
				clienteSocket.connect(address);
			} catch (Exception e) {
				try {
					System.out.println("intentando conectar");
					this.sleep(3000);
				} catch (InterruptedException e1){
				}
			}
		} while (!clienteSocket.isConnected());
		System.out.println("Conectado al Servidor");
		while (true){
			
		}
	}
}
