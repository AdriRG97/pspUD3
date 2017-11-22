package act04;

import java.util.concurrent.Semaphore;

public class Hilo3 extends Thread {

    protected Semaphore finHiloPrioritario3;
    public Hilo3(Semaphore finHiloPrioritario3) {
        this.finHiloPrioritario3=finHiloPrioritario3;
    }

    @Override
    public void run(){
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo3");
        this.finHiloPrioritario3.release();
    }
}
