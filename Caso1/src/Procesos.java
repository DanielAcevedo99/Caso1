
public class Procesos {
	
	private Buzon buzonI;//buzon entrada
	private Buzon BuzonF;//buzon salida
	private int id;
	private int tipo;// tipo 1: entrada, 2: salida, 3: intermedio
	public Procesos(int idd,Buzon ini,Buzon fini, int tip) {
		
		this.id=idd;
		this.BuzonF=fini;
		this.buzonI=ini;
		this.tipo=tip;
	}
}
