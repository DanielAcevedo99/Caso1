import java.util.ArrayList;

public class ProcesoInicial  extends Thread{
	
	private BuzonInicial buzonF;//buzon salida
	private int id;
	private ArrayList<String> cola = new ArrayList<String>();
	public ProcesoInicial(int idd,BuzonInicial fini) {
		
		this.id=idd;
		this.buzonF =fini;
	}

	private Boolean end(String d){
		if (d.equals("FIN")){
			return true;

		} else {
			return false;
		}

	}
	public void run() {
		String x="";
		int i=0;
		while (end(x)==false){
			if (buzonF.capacidadMax()) {
				this.yield();
			}else{
				buzonF.recibeMensaje(cola.get(i));
				i++;

			}

		}
	}
}
