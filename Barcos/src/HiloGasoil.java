/**
 * Created by Luis on 08/03/2017.
 */
public class HiloGasoil extends Thread {

    private ZonaCarga zc;
    private Barco b;

    public HiloGasoil (ZonaCarga zc, Barco b){
        this.zc=zc;
        this.b=b;
    }

    public void run(){
        zc.PonerGasoil(b);
    }
}
