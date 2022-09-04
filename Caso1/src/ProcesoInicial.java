import java.util.ArrayList;

public class ProcesoInicial  extends Thread{
	
	private BuzonInicial buzonF;//buzon salida
	private int id;
	private String[] cola;
	public ProcesoInicial(int idd, BuzonInicial fini, String[] mensajes) {
		
		this.id=idd;
		this.buzonF =fini;
		this.cola=mensajes;
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


		for (int j = 0; j <35 ; j++)
		{
			if (buzonF.capacidadMax()) {
				this.yield();
			}else{
				if (cola[j]!=null) {
					buzonF.recibeMensaje(cola[j]);
					System.out.println(cola[j] + " entra a buzon inicial");
				}

			}

		}
	}
}
