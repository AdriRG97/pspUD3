package act07;

import java.util.concurrent.SynchronousQueue;

public class Consumidor extends Thread {

    private static final int NUMERO_ITERACIONES = 15;
    private SynchronousQueue<Integer> queue;

    public Consumidor(SynchronousQueue<Integer> q){
        this.queue=q;
    }

    @Override
    public void run() {
        for (int i = 0; i < Consumidor.NUMERO_ITERACIONES; i++) {
            try {
                Thread.sleep(500);
                System.out.println(queue.take());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
