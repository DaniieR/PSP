package tema2;

import java.util.Scanner;

class RunnableClass1 implements Runnable{
	
	int n;
	

	public  RunnableClass1 (int numero) {
		this.n = numero;
	}
	
	public void run(){
		int numero1,numero2,sum;
		numero1=0;
		numero2=1;
		sum=numero1+numero2;
		System.out.print(numero1+" "+numero2+" "+sum+" ");
        	for(int i=0;i<n-3;i++){
        		numero1=numero2;
        		numero2=sum;
        		sum=numero1+numero2;
        		System.out.print(sum+" ");
        	}
		}
}

public class Ejercicios1 {
	public static void main (String args[]){
	
		//Pedir número al usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el numero: ");
		int numero = sc.nextInt(); 
		//crear un objeto Thread pasandole el número
		RunnableClass1 hilo =  new RunnableClass1(numero);
		//ejecutar el objeto anterior
		Thread hilo1 = new Thread(hilo);
		hilo1.setName("Hilo1");
		hilo1.start();
		
		/*RunnableClass rc = new RunnableClass();
		
*/	}
}
