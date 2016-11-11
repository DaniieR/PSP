package tema2;

class HiloPrioridad4 extends Thread {
	public void run() {
		int numero=0;
		
	}
}
public class PruebaSincrona {
	public static void main (String[]args){
	HiloPrioridad4 hilo1 =  new HiloPrioridad4();
	HiloPrioridad4 hilo2 =  new HiloPrioridad4();
	hilo1.start();
	hilo2.start();
	}
}
