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
	
	public abstract void recibeMensaje(String mensaje);
	
	public abstract String sacaMensaje();

	public abstract boolean capacidadMax();
	public abstract boolean vacio();
}
