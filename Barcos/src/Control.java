/**
 * Created by danie on 20/02/2017.
 */
public class Control {
    int quierenSalir;
    int entrada;
    int salida;

    public Control () {
        entrada = 0;
        salida = 0;
    }

    public void permisoEntrada (Barco barco) {
        synchronized (this) {
            while (salida > 0 || quierenSalir > 0) {
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
            while (entrada > 0) {
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

    public void finEntrada (Barco barco) {
        entrada--;
    }

    public void finSalida (Barco barco) {
        salida--;
        if (quierenSalir > 0)
            quierenSalir--;
    }

    public void barcoQuiereSalir () {
        quierenSalir++;
    }
}
