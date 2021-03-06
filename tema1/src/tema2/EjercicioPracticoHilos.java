package tema2;

public class EjercicioPracticoHilos extends Thread {
	private static int variable = 0;
	private static EjercicioPracticoHilos hilo1 = new EjercicioPracticoHilos();
	private static EjercicioPracticoHilos hilo2 = new EjercicioPracticoHilos();

	public void run() {
		
		if(this.getName().compareTo("Hilo 1")==0){
			System.out.println("Soy el "+this.currentThread().getName());
			
			for(int i=0; i<10; i++){	
				variable++;
			}	
			hilo2.interrupt();
			System.out.println("Me voy a esperar al 2");
			try {
				hilo2.join();
			} catch (InterruptedException e) {
				
			}
			System.out.println(variable);
		} else {
					
			try {
				System.out.println("Soy el "+this.currentThread().getName());
				System.out.println("Me voy al hilo 1");
				hilo1.join();
			} catch (InterruptedException e) {
				
			}
			for(int i=0; i<5;i++){
				variable--;
			}	

		}
		
	}

	public static void main(String[] args) {
		hilo1.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hilo1.start();
		hilo2.start();
	}

}