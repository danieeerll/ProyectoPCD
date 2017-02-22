
public class Barco extends Thread {

	int id;
	int direccion;
	Puerta p;
	Control c;

	public Barco(int id, int direccion, Puerta p, Control c) {
		this.id = id;
		this.direccion = direccion;
		this.p = p;
		this.c = c;
	}

	@Override
	public void run() {
		if (direccion == 0)
			p.entrar(this);
		if (direccion == 1)
			p.salir(this);
	}
}
