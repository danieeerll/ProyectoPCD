import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by Luis on 01/03/2017.
 */
public class ZonaCarga {

    int [] TanquesGasoil = new int[5];
    int tanqueA;

    static Semaphore mutex = new Semaphore (1);
    static Semaphore mutex2 = new Semaphore (1);
    static Semaphore[] mutexCntTanques = new Semaphore[5];
    static Semaphore tanqueAgua = new Semaphore (1);

    ArrayList <Barco> Barcos = new ArrayList<>();

    int cntTanquesVacios;

    public ZonaCarga ( ){
        for (int i=0; i<5;i++)
            this.TanquesGasoil[i]=1000;
        for (int i = 0; i < 5; i++)
            mutexCntTanques[i] = new Semaphore(1);
        this.tanqueA=999999;
        this.cntTanquesVacios=0;
    }

    private void Reponedor() {
        for (int i=0; i<5;i++)
            this.TanquesGasoil[i]=1000;
        System.out.println("Reponiendo los tanques de GASOIL");
    }

    public void PonerGasoil(Barco b){
        boolean encontrado= false;
        int indice=0;
        for (int i=0;i<this.Barcos.size() && !encontrado;i++){
            if (this.Barcos.get(i).getID() == b.getID()){
                encontrado=true;
                indice=i;
            }
        }
        while (this.Barcos.get(indice).gasoil < 3000) {
            if (this.TanquesGasoil[indice] >= 250){
                this.TanquesGasoil[indice] -= 250;
                this.Barcos.get(indice).gasoil += 250;
                System.out.println("Pongo 250 de gasolil en " + Barcos.get(indice).getID());
            }
            if (this.TanquesGasoil[indice] == 0){
                if(mutexCntTanques[indice].availablePermits() == 1) {
                    try {
                        mutex2.acquire(); mutexCntTanques[indice].acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cntTanquesVacios++;
                    if (cntTanquesVacios == 5) {
                        Reponedor();
                        cntTanquesVacios = 0;
                        for (int i = 0; i < 5; i++)
                            mutexCntTanques[i].release();

                    }
                    mutex2.release();
                }
            }
        }
        System.out.println("BARCO "+b.getID() + " TERMINA DE PONER GASOIL");
    }

    public void PonerAgua (Barco b){
        while(b.agua<5000){
            try {
                tanqueAgua.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.agua+=1000;
            System.out.println("BARCO "+b.getID() + " TERMINA DE PONER AGUA");
            tanqueAgua.release();
        }
    }

    public void RecibirBarco (Barco b){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.Barcos.add(b);
        mutex.release();
    }


}
