package tema3;
import java.awt.LinearGradientPaint;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ServidorMensajeArchivo {
    
    public static void main(String[] args) {
        try {
            
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();
            
            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("192.168.26.247",5555) ;
            
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");
            Socket newSocket = serverSocket.accept();
            
            System.out.println("Conexión recibida");
            OutputStream os = newSocket.getOutputStream();
            
            
            FileReader fr=new FileReader("vetusta.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            
            
            while ((linea=br.readLine())!=null) {
                linea += "\r\n";
                //os.write(linea.getBytes());
                System.out.println(linea);
                
            }
            System.out.println(linea);
            if (linea==null)
                System.out.println(linea.getBytes());
            
//            linea = "n";
//            os.write(linea.getBytes());
//            System.out.println("mensaje enviado terminado");
            
            
            System.out.println("Cerrando el nuevo socket");
            
            newSocket.close();
            System.out.println("Cerrando el socket servidor");
            
            serverSocket.close();
            System.out.println("Terminado");
            
            } catch (IOException e) {
            e.printStackTrace();
            }
        }

    }