public class BuzonInicial extends Buzon {
    
    public BuzonInicial(int tamano) {
        super(tamano);
    }

    /**
     * Añade un mensaje al buzón inicial.
     * OJO: La responsabilidad de verificar que el Buzón
     * tenga espacio es del Proceso inicial, por lo que
     * es el Proceso inicial quien debe hacer Yield en
     * caso de no haber espacio.
     * Una vez añade el mensaje, hace notify() para
     * despertar a los consumidores que estén esperando
     * mensajes.
     * @param mensaje - Mensaje a añadir
     */
    public synchronized void recibeMensaje(String mensaje) {
        if (cola.size() == tamano) {
            System.out.println("Se intentó agregar un mensaje cuando el buzon inicial estaba lleno");
        }
        cola.add(mensaje);
        notify();
    }

    /**
	 * Saca el mensaje en el tope de la cola y lo retorna
     * Si la cola no tiene mensajes hace wait().
	 */
    public synchronized String sacaMensaje() {
        while(cola.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cola.remove();
    }
}
