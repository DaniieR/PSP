/*Comprueba el funcionamiento de los hilos tipo daemon creando una copia del
 ejercicio 4 y añadiendo un hilo nuevo que será de tipo daemon y esperará 20 segundos.*/
package tema2;
class HiloEjercicio6 extends Thread{
	public int tiempo;
	public HiloEjercicio6 (int tiempo){
		this.tiempo = tiempo;
	}
	public void run(){
		System.out.println("Soy el "+ Thread.currentThread().getName() +" y voy a esperar "+tiempo/1000+" segundos");
	 	try {
	 		Thread.sleep(tiempo);
	
	 	} catch (InterruptedException e) {
	 		System.out.println(Thread.currentThread().getName() +" interrumpido.");
	 		return;
	 }
	 	System.out.println(Thread.currentThread().getName() +" acabado.");
	 }		
}

public class Ejercicio6 {
	public static void main (String[]args){
		System.out.println("Empieza el proceso del padre y voy a esperar 4 segundos");
		HiloEjercicio6 hilo = new HiloEjercicio6(3000);
		HiloEjercicio6 hilo2 = new HiloEjercicio6(5000);
		HiloEjercicio6 hiloDaemon = new HiloEjercicio6(20000);
		hilo.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hiloDaemon.setDaemon(true);
		hiloDaemon.setName("Hilo Daemon");
		hilo.start();
		hilo2.start();
		hiloDaemon.start();
		try{
			Thread.sleep(4000);
			
		}catch (Exception e) {
			System.out.println(Thread.currentThread().getName() +" interrumpido.");
	 		return;
		}
		System.out.println("Acaba el proceso padre");
	}
}
