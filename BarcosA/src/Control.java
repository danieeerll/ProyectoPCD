import java.util.LinkedList;

/**
 * Created by danie on 20/02/2017.
 */
public class Control {
    int quierenSalir;
    int entrada;
    int salida;
    LinkedList <Barco> LE;
    LinkedList <Barco> LS;

    public Control () {
        entrada = 0;
        salida = 0;
        quierenSalir = 0;
        LE = new LinkedList<>();
        LS = new LinkedList<>();
    }

    public synchronized void addBarcoEntrada (Barco barco) {
        LE.add(barco);
    }

    public synchronized void addBarcoSalida (Barco barco) {
        LS.add(barco);
    }

    boolean leTocaEntrar (Barco barco) {
        return LE.getFirst().id == barco.id;
    }

    boolean leTocaSalir (Barco barco) {
        return LS.getFirst().id == barco.id;
    }

    public void permisoEntrada (Barco barco) {
        synchronized (this) {
            while (salida > 0 || quierenSalir > 0 || !leTocaEntrar(barco)) {
                try {
                    wait();
                } catch(InterruptedException e){}
            }
            entrada++;
            System.out.printf("El barco " + barco.id + " está entrando \n");
            System.out.printf("El barco " + barco.id + " está entrando \n");
            System.out.printf("El barco " + barco.id + " está entrando \n");
            notifyAll();
        }
    }

    public void permisoSalida (Barco barco) {
        synchronized (this) {
            while (entrada > 0 || !leTocaSalir(barco)) {
                try {
                    wait();
                } catch(InterruptedException e){}
            }
            salida++;
            System.out.printf("El barco " + barco.id + " está saliendo \n");
            System.out.printf("El barco " + barco.id + " está saliendo \n");
            System.out.printf("El barco " + barco.id + " está saliendo \n");
            notifyAll();
        }
    }

    public synchronized void finEntrada (Barco barco) {
        entrada--;
        LE.pop();
    }

    public synchronized void finSalida (Barco barco) {
        salida--;
        quierenSalir--;
        LS.pop();
    }

    public synchronized void barcoQuiereSalir () {
        quierenSalir++;
    }
}
