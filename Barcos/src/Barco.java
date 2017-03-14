import java.util.Objects;

public class Barco extends Thread {
	
	int direccion;
	int id;
	boolean petrolero;
	int agua;
	int gasoil;

	Puerta p;
	TorreControl control;
	ZonaCarga zonaC;
	
	public Barco (Puerta p, TorreControl control, ZonaCarga zonaC, int direccion, int id, boolean petrolero){
		this.direccion = direccion;
		this.id = id;
		this.p = p;
		this.control = control;
		this.petrolero = petrolero;
		this.zonaC = zonaC;
		this.agua = 0;
		this.gasoil = 0;
	}
	
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public int getID() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (this.getDireccion()==0){
			p.Entrar(this, zonaC);
		}else{
			p.Salir(this);
		}
		
	}

	
	
	
}
