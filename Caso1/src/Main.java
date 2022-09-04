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

		String[] mensajes=new String[35];
		for (int j = 0; j <35 ; j++) {
			String men="M"+j;
			mensajes[j]=men;
		}
		ProcesoInicial ini= new ProcesoInicial(0, (BuzonInicial) buzonInicial,mensajes);
		ProcesoFinal fini = new ProcesoFinal(11, (BuzonFinal) buzonFinal);
		ProcesoIntermedio[] p= new ProcesoIntermedio[9];
		for (int i = 0; i <3 ; i++) {//procesos nivel 1
			ProcesoIntermedio pmid= new ProcesoIntermedio((BuzonIntermedio)buzonInicial,(BuzonIntermedio)buzsn1[i],i+1,1);
			p[i]=pmid;
		}
		for (int i = 0; i <3 ; i++) {//procesos nivel 2
			ProcesoIntermedio pmid= new ProcesoIntermedio((BuzonIntermedio) buzsn1[i], (BuzonIntermedio) buzsn2[i],i+1,2);
			p[i+3]=pmid;

		}

		for (int i = 0; i <3 ; i++) {//procesos nivel 3
			ProcesoIntermedio pmid= new ProcesoIntermedio( (BuzonIntermedio)buzsn2[i],(BuzonIntermedio) buzonFinal,i+1,3);
			p[i+6]=pmid;

		}

		//iniciar run de procesos
		ini.start();
		for (int i = 0; i <p.length ; i++) {
			p[i].start();
		}
		fini.start();


	}

















}







