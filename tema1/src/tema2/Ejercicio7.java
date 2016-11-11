/*Prueba el ejemplo anterior en tu equipo. Ejecuta el programa varias veces

cambiando la prioridad de los hilos y comprueba si se nota este cambio.

Haz que se creen cuatro hilos más y vuelve a hacer las pruebas anteriores y comprueba si se

notan los cambios de prioridad.

¿A qué se debe este comportamiento cuando se cambian las prioridades?*/

package tema2;

class HiloPrioridad extends Thread {

	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		for (int i = 0; i < 10; i++)
			System.out.println("Soy el " + Thread.currentThread().getName() + " iteración " + i);
		System.out.println("Soy el " + Thread.currentThread().getName() + " acabando.");
	}
}

public class Ejercicio7 {

	public static void main(String[] args) {

		HiloPrioridad thread1 = new HiloPrioridad();
		HiloPrioridad thread3 = new HiloPrioridad();
		HiloPrioridad thread4 = new HiloPrioridad();
		HiloPrioridad thread5 = new HiloPrioridad();
		HiloPrioridad thread6 = new HiloPrioridad();
		thread1.setName("Hilo 1");
		thread3.setName("Hilo 3");
		thread4.setName("Hilo 4");
		thread5.setName("Hilo 5");
		thread6.setName("Hilo 6");
		thread1.setPriority(1);
		HiloPrioridad thread2 = new HiloPrioridad();
		thread2.setName("Hilo 2");
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}