package tema2;

class Barrera {

	private static int plazas;
	
	public Barrera(int plazas) {
		this.plazas = plazas;
	}
	
	public synchronized void permisoEntrar(){
		String coche = Thread.currentThread().getName();
		try {
			while (plazas<1){
				System.out.println(coche+" no ha podido entrar(¡NO HAY PLAZAS!)");
				wait();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Coche extends Thread {
	Barrera bar;
	public Coche (String nombre,Barrera bar){
		this.bar= bar;
		this.setName(nombre);
	}
}

public class Parking {
	public static void main(String[]args){
		Barrera bar = new Barrera(8);
		int n_coches = 12;
		for (int i=1;i<n_coches;i++){
			Coche coche = new Coche("Coche "+i,bar);
			coche.start();
		}
	}
}
