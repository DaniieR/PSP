/*Ejercicio 2 – Crea un programa que cree entre 1 y 10 hilos.

Cada hilo tendrá que mostrar por pantalla:

- Mensaje indicando que empieza.

- El número de hilo por orden de creación.*/

package tema2;

import java.util.Scanner;

	class Hilo11 extends Thread {
		int num=0;
		public Hilo11(int num){
			this.num=num;
		}
		public void run(){
			System.out.println("Ejecutando :"+Thread.currentThread().getName());
		}
		
	}
	
public class Ejercicios2 extends Thread {

	public static void main (String args[]){
		
		//Pedimos el numero de hilos que quiere crear
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero");
		int numero = sc.nextInt();
		for (int i=10; i<=numero; i++){
			Hilo11 hilo1 = new Hilo11(i);
			hilo1.start();
		}
	}
}
