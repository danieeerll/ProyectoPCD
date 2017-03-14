import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Puerta {
	
	private boolean entrada;

	public boolean isEntrada() {
		return entrada;
	}
	static Semaphore mutex = new Semaphore (1);

	List<Thread> Hilos = new ArrayList<>();

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}


	public Puerta (boolean entrada){
		this.entrada=entrada;
	}
	
	
	public void Entrar (Barco b, ZonaCarga zonaC){
		b.control.permisoEntrada(b);
		for (int i=0;i<3;i++)
			System.out.println("El barco "+b.getID()+" esta entrando");
		b.control.finEntrada(b);

		if (b.petrolero){
			zonaC.RecibirBarco(b);
			HiloGasoil hg= new HiloGasoil(zonaC, b);
			HiloAgua ha = new HiloAgua(zonaC, b);

			try {
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Hilos.add(hg);
			Hilos.add(ha);

			if(Hilos.size() == 10){
				for (int i=0;i<10;i++){
					Hilos.get(i).start();
				}
			}
			mutex.release();

		}


	}
	
	public void Salir (Barco b){
		//System.out.println("El barco "+b.getID()+" solicita salir");
		b.control.permisoSalida(b);
		for (int i=0;i<3;i++)
			System.out.println("El barco "+b.getID()+" esta saliendo");
		b.control.finSalida(b);
	}
}
