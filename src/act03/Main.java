package act03;

import java.util.concurrent.Semaphore;

/**
 * @author Eugenia Pérez Martínez
 * @mailto eugenia_perez@cuatrovientos.org
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore finHiloPrioritario = new Semaphore(0);
        HiloNoPrioritario noPrioritario = new HiloNoPrioritario(finHiloPrioritario);
        HiloPrioritario prioritario = new HiloPrioritario(finHiloPrioritario);
        HiloMenosPrioritario menosPrioritario=new HiloMenosPrioritario(finHiloPrioritario);
        noPrioritario.start();
        prioritario.start();
        menosPrioritario.start();
    }
}