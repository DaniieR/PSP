package tema3;

import java.net.Socket;

public class ComprobarPuertos {

	public static void main(String[]args){
		Socket miSocket;
		for (int i = 0; i < 65536; i++) {
			try {
				miSocket = new Socket("localhost", i);
				System.out.println("El puerto "+i+" esta abierto");
				miSocket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
