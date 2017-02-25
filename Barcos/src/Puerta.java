/**
 * Created by danie on 16/02/2017.
 */


public class Puerta {
    int entrada;

    public Puerta () {
        entrada = 0;
    }

    public void entrar (Barco barco) {
        barco.c.permisoEntrada(barco);
        barco.c.finEntrada(barco);
    }

    public void salir (Barco barco) {
        barco.c.permisoSalida(barco);
        barco.c.finSalida(barco);
    }
}

