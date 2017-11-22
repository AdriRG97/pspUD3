package act03;

import java.util.concurrent.Semaphore;

/**
 * * @author Eugenia Pérez Martínez * @mailto eugenia_perez@cuatrovientos.org
 */
public class HiloNoPrioritario extends Thread {
    protected Semaphore finHiloPrioritario;

    public HiloNoPrioritario(Semaphore finHiloPrioritario) {
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
        System.out.println("HiloNoPrioritario");
    }
}