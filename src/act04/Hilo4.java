package act04;

import java.util.concurrent.Semaphore;

public class Hilo4 extends Thread {
    protected Semaphore finHiloPrioritario1;
    protected Semaphore finHiloPrioritario3;

    public Hilo4(Semaphore finHiloPrioritario1, Semaphore finHiloPrioritario3) {
        this.finHiloPrioritario1=finHiloPrioritario1;
        this.finHiloPrioritario3=finHiloPrioritario3;
    }

    @Override
    public void run(){
        try {
            this.finHiloPrioritario1.acquire();
            this.finHiloPrioritario3.acquire();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo4");
        this.finHiloPrioritario1.release();
        this.finHiloPrioritario3.release();

    }
}
