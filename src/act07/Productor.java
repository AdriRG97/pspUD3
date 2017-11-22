package act07;

import java.util.concurrent.SynchronousQueue;

public class Productor extends Thread {

    private static final int NUMERO_ITERACIONES = 15;
    private SynchronousQueue<Integer> queue;

    public Productor(SynchronousQueue<Integer> q){
        this.queue=q;
    }
    int fibonacci(int n) {
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        else{
            return -1;
        }
    }
    @Override
    public void run() {
        int num;
        for (int i = 0; i < Productor.NUMERO_ITERACIONES; i++) {
            try {
                Thread.sleep(500);
                queue.put(fibonacci(i));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
