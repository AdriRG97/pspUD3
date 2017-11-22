package act04;

import java.util.concurrent.Semaphore;

public class Hilo1 extends Thread{

    protected Semaphore finHiloPrioritario1;

    public Hilo1(Semaphore finHiloPrioritario1) {
        this.finHiloPrioritario1=finHiloPrioritario1;
    }

    @Override
    public void run(){
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo1");
        this.finHiloPrioritario1.release();
    }
}
