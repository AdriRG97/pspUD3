package act07;

import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {
        SynchronousQueue<Integer> q =new SynchronousQueue<>();
        Productor productor= new Productor(q);
        Consumidor consumidor= new Consumidor(q);
        productor.start();
        consumidor.start();
    }
}
