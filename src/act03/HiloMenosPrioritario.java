package act03;

import java.util.concurrent.Semaphore;

public class HiloMenosPrioritario extends Thread{
    protected Semaphore finHiloPrioritario;

    public HiloMenosPrioritario(Semaphore finHiloPrioritario) {
        this.finHiloPrioritario = finHiloPrioritario;
    }

    @Override
    public void run() {
        try {
            this.finHiloPrioritario.acquire();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        this.finHiloPrioritario.release();
        System.out.println("HiloMenosPrioritario");
    }
}
