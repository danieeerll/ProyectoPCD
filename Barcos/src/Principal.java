import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        Puerta p = new Puerta(true);
        TorreControl control = new TorreControl(0, 0);
        List <Thread> Barcos = new ArrayList<>();

        int n;
        Random r = new Random(new Date().getTime());

        for (int i=0;i<30;i++){
            n = r.nextInt(2);
            Barco b = new Barco(p, control, n, i);
            Barcos.add(b);
            b.start();
        }
    }
}