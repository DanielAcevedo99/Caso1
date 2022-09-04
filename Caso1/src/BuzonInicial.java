public class BuzonInicial extends Buzon {
    
    public BuzonInicial(int tamano) {
        super(tamano);
    }

    public synchronized void recibeMensaje(String mensaje) {
        cola.add(mensaje);

    }

    public synchronized String sacaMensaje() {

        System.out.println(cola.peek()+" sale de buzon inicial");

        return cola.remove();
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
