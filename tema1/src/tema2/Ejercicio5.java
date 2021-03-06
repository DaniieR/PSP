package tema2;


	class HiloEjercicio5 extends Thread{
		public int tiempo;
		public HiloEjercicio5 (int tiempo){
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

	public class Ejercicio5 {
		public static void main (String[]args){
			System.out.println("Empieza el proceso del padre y voy a esperar a que acaben los hijos");
			HiloEjercicio5 hilo = new HiloEjercicio5(3000);
			HiloEjercicio5 hilo2 = new HiloEjercicio5(5000);
			hilo.setName("Hilo 1");
			hilo2.setName("Hilo 2");
			hilo.start();
			hilo2.start();
			try{
				hilo.join();
				hilo2.join();
				
			}catch (Exception e) {
				System.out.println(Thread.currentThread().getName() +" interrumpido.");
		 		return;
			}
			System.out.println("Acaba el proceso padre");
		}
	}


