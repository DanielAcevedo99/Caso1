import java.util.Scanner;

public class Main {

	static Buzon buzonInicial;
	static Buzon buzonFinal;

	 //Numero de subconjuntos
	static int n;
	//Tamaño arreglo inicial/final
	static int a;
	//Tamaño arreglo intermedio
	static int b;
	public static void main (String[] args)
	{


		Scanner leer = new Scanner(System.in);
		System.out.print("Introduzca numero de subconjuntos: ");
		n = leer.nextInt();
		System.out.print("Introduzca Tamaño de buzon inicial/final: ");

		a = leer.nextInt();
		System.out.print("Introduzca Tamaño de buzones intermedios: ");

		b = leer.nextInt();

		 Buzon buzonInicial= new Buzon(n);
		 Buzon buzonFinal= new Buzon(n);


	}
}
