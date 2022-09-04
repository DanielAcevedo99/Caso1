import java.util.Scanner;

public class Main {
	public static void main (String[] args)
	{
		Scanner leer = new Scanner(System.in);
		System.out.print("Introduzca numero de subconjuntos: ");
		int n = leer.nextInt();
		System.out.print("Introduzca Tamaño de buzon inicial/final: ");
		int s1 = leer.nextInt();
		System.out.print("Introduzca Tamaño de buzones intermedios: ");
		int s2 = leer.nextInt();
		leer.close();

		// Creación de objetos
		// Buzon inicial y final
		BuzonInicial bi = new BuzonInicial(s1);
		BuzonFinal bf = new BuzonFinal(s1);

		// Proceso inicial y final
		ProcesoInicial pi = new ProcesoInicial(bi, n);
		ProcesoFinal pf = new ProcesoFinal(bf);

		// Procesos y buzones intermedios
		for(int i = 1; i <= 3; i++) { 				// Ciclo por los niveles
			Buzon be = bi;
			for(int j = 0; j < 2; j++) { 			// Ciclo por las trasnformaciones
				Buzon bs = new BuzonIntermedio(s2);
				new ProcesoIntermedio(be, bs, 1, j+1).start();
				be = bs;
			}
			new ProcesoIntermedio(be, bf, 1, 3).start();
		}

		pi.start();
		pf.start();
		try {
			pf.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizó la ejecución del proceso final. Fin de la aplicación");
		
	}
}
