public class BuzonIntermedio extends Buzon {

    private int nivel;
    private int transformacion;
    
    public BuzonIntermedio(int tamano, int nivel, int transformacion) {
        super(tamano);
        this.nivel = nivel;
        this.transformacion = transformacion;
    }

    /**
     * Añade un mensaje a la cola de mensajes del Buzón final.
     * Si el buzón no tiene espacio, hace Wait().
     * Cuando añade el mensaje hace Notify para para despertar
     * a consumidores en espera.
     */
    public synchronized void recibeMensaje(String mensaje) {
        while(cola.size() == tamano) {
            Main.rep.rBuzonLleno(getId() , mensaje);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cola.add(mensaje);
        Main.rep.rMessageAdded(getId(), mensaje);
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
            Main.rep.rBuzonVacio(getId());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String msg = cola.remove();
        Main.rep.rMessageRemoved(getId(), msg);
        notify();
        return msg;
    }

    private String getId() {
        return "Intermedio " + nivel + "-" + transformacion;
    }


}
