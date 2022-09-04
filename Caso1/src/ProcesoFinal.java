import java.util.ArrayList;

public class ProcesoFinal extends Thread {
    private BuzonFinal buzonI;//buzon entrada
    private int id;
    private ArrayList<String> cola = new ArrayList<String>();

    public ProcesoFinal(int idd, BuzonFinal ini ) {

        this.id=idd;
        this.buzonI=ini;
    }
    public void run(){
        for (int i = 0; i < cola.size(); i++) {
            if (buzonI.vacio()) {
                this.yield();
            }else{
               cola.add( buzonI.sacaMensaje());

            }

        }

    }
    
}
