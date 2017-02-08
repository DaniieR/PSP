package Trabajo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.security.auth.callback.LanguageCallback;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

public class serverMensaje extends Thread {
	private static Socket[] clientSocket;
	private static Mensaje[] mensajes;
	private static String[] usuarios;
	private Socket socket;
	private static int ocupado=0;
	private int enviar;

	public serverMensaje(Socket socket, int enviar) {
		this.socket=socket;
		this.enviar = enviar;
		ocupado++;
	}
	public void run() {
		// Lo que va a hacer cada hilo
		int codigo = 0;
		int posicion = 0;
		for (int j = 0; j < clientSocket.length; j++) {
			if (clientSocket[j]==this.socket) {
				posicion = j;
			}
			break;
		}
		if (enviar==1) {
			try {
				System.out.println("Arrancando hilo enviar");
				
				synchronized (this.socket) {
					Mensaje mensaje = mensajes[posicion];
				}
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket[posicion].getOutputStream());
				System.out.println("Enviando Mensaje");
				switch (codigo) {
				case 2:
					/*Si el c�digo es 2 el usuario ser� el nombre de usuario un cliente que se acaba de
					conectar/desconectar del sistema, el mensaje contendr� �conectado�o �desconectado.
					Estos mensajes solo los puede env iar el servidor a los clientes.*/
					break;
				case 4:
					/*Si el c�digo es 4 el usuario estar� en blanco y el mensaje contenido en mensaje se enviar�
					 * a todos los clientes. Estos mensajes solo los puede enviar el servidor a los clientes.*/
					break;
				case 5:
					/*Si el c�digo es 5 el usuario ser� el nombre de usuario que env�a el mensaje contenido en
					 * mensaje. Estos mensajes solo los puede env iar el servidor a los clientes*/
					break;
				case 6:
					/*Si el c�digo es 6 el usuario ser� �servidor� y el mensaje contendr� �El mensaje X no se ha
					 * podido entregar a NombreUsuario por haberse desconectado del sistema�. Estos mensajes
					 * solo los puede enviar el servidor a los clientes.*/
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
		try {
			System.out.println("Arrancando hilo recibir");
			ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket[posicion].getInputStream());
			System.out.println("Esperando Mensaje");
			Mensaje miObjeto = new Mensaje();
			miObjeto = (Mensaje) objectInputStream.readObject();
			codigo = miObjeto.getCodigo();
			switch (codigo) {
			case 1:
				/*Si el c�digo es 1 el usuario ser� el nombre de usuario del cliente que se conecta y el
				mensaje ir� vac�o. Estos mensajes solo los puede enviar un cliente al servidor.*/
				System.out.println("El usuario que se ha conectado es el siguiente: "+miObjeto.getUsuario());
				synchronized (usuarios) {
					usuarios[posicion] = miObjeto.getUsuario();
				}
				break;
			case 3:
				/*Si el c�digo es 3 el usuario ser� el nombre de usuario destinatario del mensaje que se
				 * contenga en mensaje. Estos mensajes solo los pueden enviar los clientes al servidor*/
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Creando socket servidor");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("192.168.26.167", 5555);
			serverSocket.bind(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Aceptando Conexiones");
		while (serverSocket != null) {
			try {
				while (ocupado==5){
					Thread.sleep(5000);
				}
				while (ocupado<5) {

				Socket newSocket = serverSocket.accept();
				System.out.println("Conexion recibida");
				serverMensaje hilo = new serverMensaje(newSocket,0);
				serverMensaje hilo2 = new serverMensaje(newSocket,1);
				
				for (int i=0; i < clientSocket.length;i++){
					synchronized (clientSocket) {
						if (clientSocket[i]==null){
							clientSocket[i]=newSocket;
						}
					}
				}	
				
				hilo.start();
				hilo2.start();
				}
				System.out.println("Terminado");
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}