package tema1;
import java.io.*;
import java.util.Arrays;

public class EjerciciosAleatorio {
	public static void main(String[] args){
		try{
			
			Process process = new ProcessBuilder("./aleatorios").start() ;
			
			InputStream is = process.getInputStream() ;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			PrintStream ps = new PrintStream(process.getOutputStream());
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			String line;
			while((line=br2.readLine()).compareTo("fin")!=0){
				ps.println(line);
				ps.flush();
				
				if((line=br.readLine()) != null ) {
					System.out.println(line);
				}
			}
			/*//Esto es si leemos todas las lineas, las guardamos en el buffer y despues lo leemos 
			 * while((line=br.readLine()) != null ) {
			 * 	System.out.println(line);
			 * }
			 */
			System.out.println("Salida del proceso " + Arrays.toString(args) + " : " ) ;
						
		}catch(Exception e){
			System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
			
		}
	}

}
