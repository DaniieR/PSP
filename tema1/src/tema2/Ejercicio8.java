/*Crea un programa que cree 10 hilos de manera recursiva, cada hilo creará un

hilo hijo y así sucesivamente. Cada hilo padre tiene que esperar a que su hijo acabe. El último

hilo creado ha de esperar 5 segundos. Todos los hilos han de informar de quién son, que van

a empezar, que van a esperar y que han acabado.*/

package tema2;

class HiloPrioridad3 extends Thread {
	private int numeroHilos;
	public HiloPrioridad3(int numeroHilos){
		this.numeroHilos = numeroHilos;
		this.setName("Hilo "+numeroHilos);
	}
	public void run() {
		String nombre = this.getName();
		
		if (numeroHilos<10) {
			numeroHilos++;
			System.out.println("Soy "+nombre+", creo un hijo y espero a que acabe");
			HiloPrioridad3 hilo = new HiloPrioridad3(numeroHilos);
			
			try{
				hilo.sleep(500);
				hilo.start();
				hilo.join();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Soy "+ nombre +" y voy a esperarme 5 segundos.");
			try{
				this.sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		try {
			this.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Soy "+ nombre + " acabado.");
		
	}
	}


public class Ejercicio8 {

	public static void main(String[] args) {
		
		HiloPrioridad3 hilo = new HiloPrioridad3(1);
		hilo.start();
	}
}