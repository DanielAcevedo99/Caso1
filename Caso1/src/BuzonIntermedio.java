public class BuzonIntermedio  extends  Buzon{

    public BuzonIntermedio(int tamano) {
        super(tamano);
    }

    public synchronized void recibeMensaje(String mensaje) {
        while (capacidadMax()==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cola.add(mensaje);
            notify();
        }
    }

    public synchronized String sacaMensaje() {
        while (vacio() == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String x= cola.poll();
        notify();
        return x;
    }


    public boolean capacidadMax() {
        if (cola.size()==tamano){
            return true;
        }
        return false;
    }

    @Override
    public boolean vacio() {
        if (cola.size()==0){
            return true;
        }else{
            return  false;
        }

    }
}
