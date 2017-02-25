
public class Barco extends Thread {

	int id;
	int direccion;
	Puerta p;

	public Barco(int id, int direccion, Puerta p) {
		this.id = id;
		this.direccion = direccion;
		this.p = p;
	}

	@Override
	public void run() {
		if (direccion == 0)
			p.entrar(this);
		if (direccion == 1)
			p.salir(this);
	}
}
