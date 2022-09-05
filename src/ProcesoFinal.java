public class ProcesoFinal extends Thread {

    private BuzonFinal buzonE; // Buzón de entrada
    private int procesosFinalizados;

    public ProcesoFinal(BuzonFinal buzonE) {
        this.buzonE = buzonE;
        procesosFinalizados = 0;
    }

    @Override
    public void run() {
        boolean terminar = false;
        while(!terminar) {
            Main.rep.rRetriveAttempt("final");
            while(buzonE.getOcupacion() == 0) {
                Main.rep.rBuzonFinalVacio();
                this.yield();
            }
            String msg = buzonE.sacaMensaje();
            System.out.println("El proceso final recibió el mensaje: " + msg);
            if(msg == "FIN") {
                procesosFinalizados++;
                if(procesosFinalizados == 3) {
                    terminar = true;
                    Main.rep.report("El proceso final recibió el tercer mensaje 'FIN'. Finaliza su ejecución");;
                }
            }
        }
    }
}
