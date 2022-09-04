import java.util.Random;

public class ProcesoIntermedio extends Thread {
    private Buzon buzonI;//buzon entrada
    private Buzon buzonF;//buzon salida
    private int idNivel;
    private int nivel;// nivel
    public ProcesoIntermedio( BuzonIntermedio ini, BuzonIntermedio fini ,int idNiv, int niv) {

        this.idNivel =idNiv;
        this.buzonF=  fini;
        this.buzonI=  ini;
        this.nivel=niv;
    }
    public void run(){
        Random r= new Random();
        String x="";
        while (!end(x)){
            int rand= r.nextInt(500-50)+50;
             x=buzonI.sacaMensaje();
            String t= transformar(x);
            try {
                sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t);
            buzonF.recibeMensaje(t);
        }




    }

    private String transformar(String x) {
        return x+"T"+ idNivel +nivel;
    }
    private Boolean end(String d){
        if (d.equals("FIN")){
            return true;

        } else {
            return false;
        }

    }

}
