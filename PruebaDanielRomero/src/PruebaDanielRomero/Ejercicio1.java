package PruebaDanielRomero;
/***********************************************************/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Ejercicio Ejercicio1 */

/* Autor: Daniel Romero */

/* Fecha: 25 de noviembre */

/***********************************************************/
class HiloEjercicio1a extends Thread {
	
	public void run() {
		String comando = "gedit";
		
		try{
			
			Process proceso = Runtime.getRuntime().exec(comando);
			InputStream entrada = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
			
			String line;
			
			while ((line = br.readLine())!=null){
				System.out.println(line);
				proceso.destroy();
			}
			System.out.println("La aplicación se ha cerrado con éxito");
			
			} catch (Exception e){
				System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
			}
	}

}
class HiloEjercicio1b extends Thread {
	
	public void run() {
		String comando = "firefox";
		
		try{
			
			Process proceso = Runtime.getRuntime().exec(comando);
			InputStream entrada = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
			
			String line;
			
			while ((line = br.readLine())!=null){
				System.out.println(line);
				proceso.destroy();
			}
			System.out.println("La aplicación se ha cerrado con éxito");
			
			} catch (Exception e){
				System.out.println("Error ocurrió ejecutando el	comando. Descripción: " + e.getMessage());
			}
	}

}

public class Ejercicio1 {
	public static void main (String args[]){
		HiloEjercicio1a hilo1 = new HiloEjercicio1a();
		HiloEjercicio1b hilo2 = new HiloEjercicio1b();
		hilo1.setName("Hilo1");
		hilo2.setName("Hilo2");
		hilo1.start();
		hilo2.start();
	}
}
