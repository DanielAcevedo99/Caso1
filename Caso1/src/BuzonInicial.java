public class BuzonInicial extends Buzon {
    
    public BuzonInicial(int tamano) {
        super(tamano);
    }

    public synchronized void recibeMensaje(String mensaje) {
        // if (cola.size() == tamano) {
        //     throw new Exception("")
        // }
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

        }else return false;
    }
}
