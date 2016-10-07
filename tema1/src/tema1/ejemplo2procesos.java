package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class ejemplo2procesos {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
		
			String comando1 = "ls -la";
			String comando2 = "tr 'd' 'D'";
		
	
			Process hijo1 = Runtime.getRuntime().exec(comando1); /**Creación de proceso y ejecución del comando1*/
		
			InputStream ishijo1 = hijo1.getInputStream(); /**Salida de proceso hijo1 que es la entrada del proceso padre*/
			BufferedReader br = new BufferedReader(new InputStreamReader(ishijo1)); /**guardar la salida del hijo en un buffer de lectura*/
		
			String line; /**cadena vacía donde mete lo que lee del buffer*/
		
			Process hijo2 = Runtime.getRuntime().exec(comando2); /**Creación de proceso hijo 2*/
			OutputStream oshijo2 = hijo2.getOutputStream(); /**la salida del hijo1 es la entrada del hijo2*/
			PrintStream printStream = new PrintStream(oshijo2); /**meter datos dentro del Output Stream*/
			BufferedReader br2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream()));
		
		while ((line = br.readLine()) != null){ /**leer el buffer*/
			
			printStream.println(line);
			printStream.flush();
			
		}
		
		while ((line = br2.readLine()) != null){
			
			System.out.println(line);
		}
		
	
		} catch (IOException ex) {
	
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + ex.getMessage());
	
		}
	}
}
