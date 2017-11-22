package act03;

import java.util.concurrent.Semaphore;

/**
 * * @author Eugenia Pérez Martínez * @mailto eugenia_perez@cuatrovientos.org
 */
public class HiloPrioritario extends Thread {
    protected Semaphore finHiloPrioritario;

    public HiloPrioritario(Semaphore finHiloPrioritario) {
        this.finHiloPrioritario = finHiloPrioritario;
    }

    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("HiloPrioritario");
        this.finHiloPrioritario.release();
    }
}