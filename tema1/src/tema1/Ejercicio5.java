package tema1;

public class Ejercicio5 {
	public static void main(String[] args) {
		try {
		    
		        Process[] procesos = new Process[args.length];
		        int appsIniciadas = 0;
		        
		        for (String cmd:args){
		    
		            System.out.println(cmd);
		    
		            procesos[appsIniciadas] = Runtime.getRuntime().exec(cmd);
		            appsIniciadas++;
		        }
		        
		       for(int i=0; i<appsIniciadas; i++)
		           procesos[i].waitFor();
		           
		        

		        System.out.println("todas las aplicaciones finalizadas");
		        
		        
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		}
}
