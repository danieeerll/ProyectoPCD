import java.util.LinkedList;

public class TorreControl {
	private int entrando;
	private int saliendo;
	private int quierensalir;

	private LinkedList <Barco> esperandoS;
    private LinkedList <Barco> esperandoE;

	public int getEntrando() {
		return entrando;
	}

	public void setEntrando(int entrando) {
		this.entrando = entrando;
	}

	public int getSaliendo() {
		return saliendo;
	}

	public void setSaliendo(int saliendo) {
		this.saliendo = saliendo;
	}

	public int getQuierensalir() {
		return quierensalir;
	}

	public void setQuierensalir(int quierensalir) {
		this.quierensalir = quierensalir;
	}

	public TorreControl (int entrando, int saliendo){
		this.entrando=entrando;
		this.saliendo=saliendo;
		this.esperandoS = new LinkedList<>();
        this.esperandoE = new LinkedList<>();
	}
	
	public synchronized void permisoEntrada (Barco b){
		while (saliendo>0 || quierensalir>0) {
            if (!this.esperandoE.contains(b)) {
                this.esperandoE.addLast(b);
            }
            try {
                wait();
            } catch (InterruptedException e) {}
            if(!this.esperandoE.getFirst().equals(b)){
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
        }
        entrando++;
        this.esperandoE.remove(b);
	}
	
	public synchronized void  permisoSalida (Barco b){
			while (entrando>0) {
			    if (!this.esperandoS.contains(b)) {
                    this.esperandoS.addLast(b);
                }
                try {
                    quierensalir++;
                    wait();
                    quierensalir--;
                } catch (InterruptedException e) {}
                if(!this.esperandoS.getFirst().equals(b)) {
                    try {
                        quierensalir++;
                        wait();
                        quierensalir--;
                    } catch (InterruptedException e) {}
                }
            }
            this.esperandoS.remove(b);
			saliendo++;
	}
	
	public synchronized void finEntrada (Barco b){
			entrando--;
			if(quierensalir>0)
				notifyAll();
	}
	
	public synchronized void finSalida (Barco b){
			saliendo--;
			if (saliendo==0)
				notifyAll();
	}
}
