public class BuzonFinal extends Buzon {
    public BuzonFinal(int tamano) {
        super(tamano);
    }

    public synchronized void recibeMensaje(String mensaje) {
      cola.add(mensaje);
    }

    public synchronized String sacaMensaje() {

        return "";
    }


    public boolean capacidadMax() {
        if (cola.size()==tamano){
            return true;
        }
        return false;
    }


    public boolean vacio() {
        if (cola.size()==0){
            return true;
        }else{
            return  false;
        }

    }
}
