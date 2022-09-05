import java.util.concurrent.ThreadLocalRandom;

public class ProcesoInicial extends Thread {
	
	private BuzonInicial buzonS; //buzon salida
	private int n; // Número de sub conjuntos
	
	/**
	 * @param buzonS Buzón inicial
	 * @param n número de sub conjuntos
	 */
	public ProcesoInicial(BuzonInicial buzonS, int n) {
		this.buzonS = buzonS;
		this.n = n;
	}

	@Override
	public void run() {
		// Creación de n sub conjuntos
		for(int i = 1; i <= n; i++) {
			String msg = "M" + i;
			int time = ThreadLocalRandom.current().nextInt(50, 501);
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Main.rep.rSendAttempt("inicial", msg);
			while(buzonS.getCapacidad() == 0) {
				Main.rep.rBuzonLleno("inicial", msg);
				this.yield();
			}
			buzonS.recibeMensaje(msg);
		}

		// Envía el mensaje de finalización para todos los niveles.
		for(int i = 0; i < 3; i++) {
			String msg = "FIN";
			int time = ThreadLocalRandom.current().nextInt(50, 501);
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Main.rep.rSendAttempt("inicial", msg);
			while(buzonS.getCapacidad() == 0) {
				Main.rep.rBuzonLleno("inicial", msg);
				this.yield();
			}
			buzonS.recibeMensaje(msg);
		}

		Main.rep.report("El proceo inicial envió todos los mensajes. Finaliza su ejecución");
	}
}
