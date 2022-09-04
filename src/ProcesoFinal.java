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
            while(buzonE.getOcupacion() == 0) {
                this.yield();
            }
            String msg = buzonE.sacaMensaje();
            if(msg == "FIN") {
                procesosFinalizados++;
                if(procesosFinalizados == 3) {
                    terminar = true;
                }
            }
        }
    }
}
