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
        System.out.printf("Clase puerta ENTRAR\n");

        barco.c.finEntrada(barco);
    }

    public void salir (Barco barco) {
        barco.c.permisoSalida(barco);
        System.out.printf("Clase puerta SALIR\n");

        barco.c.finSalida(barco);
    }
}

