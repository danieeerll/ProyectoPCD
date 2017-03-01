
public class Puerta {
	
	private boolean entrada;
	
	
	
	public boolean isEntrada() {
		return entrada;
	}


	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}


	public Puerta (boolean entrada){
		this.entrada=entrada;
	}
	
	
	public void Entrar (Barco b){
		//System.out.println("El barco "+b.getID()+" solicita entrar");
		b.control.permisoEntrada(b);
		for (int i=0;i<3;i++)
			System.out.println("El barco "+b.getID()+" esta entrando");
		b.control.finEntrada(b);
	}
	
	public void Salir (Barco b){
		//System.out.println("El barco "+b.getID()+" solicita salir");
		b.control.permisoSalida(b);
		for (int i=0;i<3;i++)
			System.out.println("El barco "+b.getID()+" esta saliendo");
		b.control.finSalida(b);
	}
}
