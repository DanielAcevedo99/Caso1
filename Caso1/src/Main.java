import java.util.Scanner;

public class Main {

	static BuzonInicial buzonInicial;
	static BuzonFinal buzonFinal;

	//Numero de subconjuntos
	static int n;
	//Tamaño arreglo inicial/final
	static int a;
	//Tamaño arreglo intermedio
	static int b;
	public static void main (String[] args) {


		Scanner leer = new Scanner(System.in);
		System.out.print("Introduzca numero de subconjuntos: ");
		n = leer.nextInt();

		System.out.print("Introduzca Tamaño de buzon inicial/final: ");
		a = leer.nextInt();

		System.out.print("Introduzca Tamaño de buzones intermedios: ");
		b = leer.nextInt();

		buzonInicial= new BuzonInicial(a);
		buzonFinal=new BuzonFinal(a);
		Buzon[] buzsn1= new BuzonIntermedio[3];

		Buzon[] buzsn2= new BuzonIntermedio[3];


		for (int i = 0; i <3 ; i++) {
			BuzonIntermedio bmed= new BuzonIntermedio(b);
			buzsn1[i]=bmed;
		}
		for (int i = 0; i <3 ; i++) {
			BuzonIntermedio bmed= new BuzonIntermedio(b);
			buzsn2[i]=bmed;
		}
		ProcesoInicial ini= new ProcesoInicial(0, buzonInicial );
		ProcesoFinal fini = new ProcesoFinal(11,buzonFinal);
		ProcesoIntermedio[] p= new ProcesoIntermedio[9];
		for (int i = 0; i <3 ; i++) {//procesos nivel 1
			ProcesoIntermedio pmid= new ProcesoIntermedio(buzonInicial,buzsn1[i],i+1,1);
			p[i]=pmid;
		}
		for (int i = 0; i <3 ; i++) {//procesos nivel 2
			ProcesoIntermedio pmid= new ProcesoIntermedio(buzsn1[i],buzsn2[i],i+1,2);
			p[i]=pmid;

		}

		for (int i = 0; i <3 ; i++) {//procesos nivel 3
			ProcesoIntermedio pmid= new ProcesoIntermedio(buzsn2[i],buzonFinal,i+1,3);
			p[i]=pmid;

		}

		//iniciar run de procesos
		ini.start();
		for (int i = 0; i <p.length ; i++) {
			p[i].start();
		}
		fini.start();


	}

















}







