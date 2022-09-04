import java.util.LinkedList;
import java.util.Queue;

public abstract class Buzon {

	// ==== ATRIBUTOS ====
	protected int tamano; //tamaño buzon
	protected Queue<String> cola = new LinkedList<String>();

	// ==== METODOS ====
	public Buzon(int tamano) {
		this.tamano = tamano;
	}
	
	/**
	 * Añade un mensaje a la cola de mensajes del Buzón final.
	 */
	public abstract void recibeMensaje(String mensaje);
	
	/**
	 * Saca el mensaje en el tope de la cola y lo retorna
	 */
	public abstract String sacaMensaje();

	/**
	 * Retorna la capacidad actual del buzón.
	 */
	public synchronized int getCapacidad() {
		return tamano - cola.size();
	}

	/**
	 * Retorna la cantidad actual de mensajes en la cola
	 */
	public synchronized int getOcupacion() {
		return cola.size();
	}

}
