import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread {
    
    private int nivel; // Número de nivel
    private int transformacion; // Número de transformación
    private Buzon buzonE; // Buzón de entrada
    private Buzon buzonS; // Buzón de salida

    public ProcesoIntermedio(Buzon buzonE, Buzon buzonS, int nivel, int transformacion) {
        this.nivel = nivel;
        this.transformacion = transformacion;
        this.buzonE = buzonE;
        this.buzonS = buzonS;
    }

    @Override
    public void run() {
        boolean terminar = false;
        while(!terminar) {
            Main.rep.rRetriveAttempt(getIdentifier());
            String msg = buzonE.sacaMensaje();
            if(msg == "FIN") {
                terminar = true;
            } else {
                msg += "T" + transformacion + nivel;
            }
            int time = ThreadLocalRandom.current().nextInt(50, 501);
            try {
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.rep.rSendAttempt(getIdentifier(), msg);
            buzonS.recibeMensaje(msg);
            if(msg == "FIN") {
                Main.rep.rEndOfExecution(getIdentifier());
            }
        }
    }

    private String getIdentifier() {
        return "intermedio " + transformacion + "-" + nivel;
    }
}
