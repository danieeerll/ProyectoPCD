
public class Barco extends Thread {
	
	int direccion;
	int id;
	Puerta p;
	TorreControl control;
	
	public Barco (Puerta p, TorreControl control, int direccion, int id){
		this.direccion=direccion;
		this.id=id;
		this.p=p;
		this.control=control;
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
			p.Entrar(this);
		}else{
			p.Salir(this);
		}
		
	}
	
	
	
}
