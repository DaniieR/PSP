package tema2;

class HiloEjercicio3 extends Thread {
	 public void run() {
	 System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");
	 	try {
	 		Thread.sleep(5000);
	
	 	} catch (InterruptedException e) {
	 		System.out.println(Thread.currentThread().getName() +" interrumpido.");
	 		return;
	 }
	 	System.out.println(Thread.currentThread().getName() +" acabado.");
	 }
}

public class Ejercicio3 {
public static void main (String[]args){
	HiloEjercicio3 hilo = new HiloEjercicio3();
	hilo.start();
	try{
		hilo.sleep(8000);
	} catch (InterruptedException e){
		//System.out.println("Interrumpido");
		return;
	}
	hilo.interrupt();
	//System.out.println("Acabo la ejecucion");
}
}