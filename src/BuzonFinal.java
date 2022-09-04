public class BuzonFinal extends Buzon {

    public BuzonFinal(int tamano) {
        super(tamano);
    }

    /**
     * Añade un mensaje a la cola de mensajes del Buzón final.
     * Si el buzón no tiene espacio, hace Wait().
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
    }

    /**
     * Saca el mensaje en el tope de la cola y lo retorna.
     * OJO: La responsabilidad de determinar
     * si el buzón tiene mensajes para entregar es
     * del proceso final, por lo que el proceso
     * final es quien debe hacer Yield si no hay mensajes
     * para consumir.
     * Una vez saca el mensaje, hace notify() para
     * despertar a un productos que estubiera dormido
     * esperando añadir un mensaje.
     */
    public synchronized String sacaMensaje(){
        if(cola.size() == 0) {
            System.out.println("Se intentó sacar un mensaje del buzón final cuando este no tenía nungino");
        }
        String msg = cola.remove();
        notify();
        return msg;
    }
    
}
