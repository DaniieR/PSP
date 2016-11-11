package tema2;

class HiloVocal extends Thread{
	
	public static int contador=0;
	private String cadena = "holaksjdlajsdjial,scnouieholajncljsbnowahlawijqopwijcxjnalcsnqoiwhdqkljcnalschoiehaclejncaluiehalsmncaliwehclajn";
	
	public HiloVocal(String nombre){
		this.setName(nombre);
	}
	
	public void run() {
		if (this.getName().compareTo("hilo a")==0){
			this.ContarA();
		}
		if (this.getName().compareTo("hilo e")==0){
			this.ContarE();
		}
		if (this.getName().compareTo("hilo i")==0){
			this.ContarI();
		}
		if (this.getName().compareTo("hilo o")==0){
			this.ContarO();
		}
		if (this.getName().compareTo("hilo u")==0){
			this.ContarU();
		}
	}
	public  void ContarA(){
		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)=='a' || cadena.charAt(i)=='A') {
				//contador++;
				this.sumaVocal();
			}
		}
	}
	public  void ContarE(){
		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)=='e' || cadena.charAt(i)=='E') {
				//contador++;
				this.sumaVocal();
			}
		}
	}
	public  void ContarI(){
		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)=='i' || cadena.charAt(i)=='I') {
				//contador++;
				this.sumaVocal();
			}
		}
	}
	public  void ContarO(){
		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)=='o' || cadena.charAt(i)=='O') {
				//contador++;
				this.sumaVocal();
			}
		}
	}
	public void ContarU(){
		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)=='u' || cadena.charAt(i)=='U') {
	//			contador++;
				this.sumaVocal();
			}
		}
	}
	public synchronized void sumaVocal(){
		contador++;
	}
	
	public static int GetCont(){
		return contador;
	}
}


public class Ejercicio9 {
	public static void main (String[]args){
		HiloVocal hilo1 = new HiloVocal("hilo a");
		HiloVocal hilo2 = new HiloVocal("hilo e");
		HiloVocal hilo3 = new HiloVocal("hilo i");
		HiloVocal hilo4 = new HiloVocal("hilo o");
		HiloVocal hilo5 = new HiloVocal("hilo u");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El numero de vocales son: "+HiloVocal.GetCont());
	}
}
