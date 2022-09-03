import java.util.LinkedList;
import java.util.Queue;

public class Buzon {
	private int tamano;//tamaño buzon
	private Queue<String> cola= new LinkedList<String>();
	public Buzon(int n) {
		this.tamano=n;
	}
	
	public synchronized void recibeMensaje() {
		if (tamano==0) {
			
		}
	}
	
	public synchronized String sacaMensaje() {
		
		return "";
	}
}
