public class BuzonIntermedio extends Buzon {
    
    public BuzonIntermedio(int tamano) {
        super(tamano);
    }

    /**
     * Añade un mensaje a la cola de mensajes del Buzón final.
     * Si el buzón no tiene espacio, hace Wait().
     * Cuando añade el mensaje hace Notify para para despertar
     * a consumidores en espera.
     */
    public synchronized void recibeMensaje(String mensaje) {
        while(cola.size() == tamano) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cola.add(mensaje);
        notify();
    }

    /**
	 * Saca el mensaje en el tope de la cola y lo retorna
     * Si la cola no tiene mensajes hace wait().
     * Cuando saca el mensaje hace notify para despertar
     * a productores en espera.
	 */
    public synchronized String sacaMensaje() {
        while(cola.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String msg = cola.remove();
        notify();
        return msg;
    }


}
