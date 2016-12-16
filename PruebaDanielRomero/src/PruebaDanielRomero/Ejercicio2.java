package PruebaDanielRomero;
/***********************************************************/

/* Ejercicio Ejercicio2 */

/* Autor: Daniel Romero */

/* Fecha: 25 de noviembre */

/***********************************************************/
public class Ejercicio2 extends Thread {
	private static Ejercicio2 hilo1 = new Ejercicio2();
	private static Ejercicio2 hilo2 = new Ejercicio2();

	public void run() {
		if(this.getName().compareTo("Hilo1")==0){
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		
		for (int i = 0; i<5; i++){
			System.out.println("A mí me rebota y a ti te explota");
			hilo2.interrupt();
			try{
				hilo2.join();
			} catch (Exception e) {
				// TODO: handle exception
				}
			}
		}
		if(this.getName().compareTo("Hilo2")==0){
		for (int i = 0; i<5; i++){
			try{
				hilo1.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Y a ti mas");
			hilo1.interrupt();
		}
		
	}
	
}		
public static void main (String args[]){
			hilo1.setName("Hilo1");
			hilo2.setName("Hilo2");
			hilo2.start();
			hilo1.start();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try{
				hilo1.join();
				hilo2.join();
				
			}catch (Exception e) {
				System.out.println(Thread.currentThread().getName() +" interrumpido.");
		 		return;
			}
			System.out.println("Dejaos de gilipolleces");
		}
		
	}