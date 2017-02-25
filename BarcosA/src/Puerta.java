/**
 * Created by danie on 16/02/2017.
 */


public class Puerta {
    Control c;
    int entrada;

    public Puerta (Control c) {
        entrada = 1;
        this.c = c;
    }

    public void entrar (Barco barco) {
        c.addBarcoEntrada(barco);
        c.permisoEntrada(barco);
        c.finEntrada(barco);
    }

    public void salir (Barco barco) {
        c.barcoQuiereSalir();
        c.addBarcoSalida(barco);
        c.permisoSalida(barco);
        c.finSalida(barco);
    }
}

