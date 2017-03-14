/**
 * Created by Luis on 08/03/2017.
 */
public class HiloAgua extends Thread {

    private ZonaCarga zc;
    private Barco b;

    public HiloAgua (ZonaCarga zc, Barco b){
        this.zc=zc;
        this.b=b;
    }

    public void run(){
        zc.PonerAgua(b);
    }
}
