/*– Crea un programa que cree dos hilos.
Después de empezar un hilo hijo debe esperar 3 segundos y el otro hilo hijo debe esperar 5
segundos.
El hilo principal después de crear a los dos hijos debe esperar 4 segundos.
Cada hijo debe de mostrar por pantalla su nombre y cuánto tiempo va a esperar*/
package tema2;
class HiloEjercicio4 extends Thread{
	public int tiempo;
	public HiloEjercicio4 (int tiempo){
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

public class Ejercicio4 {
	public static void main (String[]args){
		System.out.println("Empieza el proceso del padre y voy a esperar 4 segundos");
		HiloEjercicio4 hilo = new HiloEjercicio4(3000);
		HiloEjercicio4 hilo2 = new HiloEjercicio4(5000);
		hilo.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hilo.start();
		hilo2.start();
		try{
			Thread.sleep(4000);
			
		}catch (Exception e) {
			System.out.println(Thread.currentThread().getName() +" interrumpido.");
	 		return;
		}
		System.out.println("Acaba el proceso padre");
	}
}
