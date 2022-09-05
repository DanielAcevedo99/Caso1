import java.time.LocalDateTime;
import java.util.Scanner;

import Utils.Reporter;

public class Main {

	public static final Reporter rep = new Reporter("ExecReport " + LocalDateTime.now().toString());
	
	public static void main(String[] args)
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
		pi.start();
		ProcesoFinal pf = new ProcesoFinal(bf);

		// Procesos y buzones intermedios
		for(int i = 1; i <= 3; i++) { 				// Ciclo por los niveles
			Buzon be = bi;
			for(int j = 1; j < 3; j++) { 			// Ciclo por las trasnformaciones
				Buzon bs = new BuzonIntermedio(s2, i, j);
				new ProcesoIntermedio(be, bs, i, j).start();
				be = bs;
			}
			new ProcesoIntermedio(be, bf, i, 3).start();
		}

		pf.start();
		try {
			pf.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rep.report("Finalizó la ejecución del proceso final. Fin de la aplicación");
		rep.close();
	}
}
