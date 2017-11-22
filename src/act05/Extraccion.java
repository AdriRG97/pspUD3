package act05;

import java.util.concurrent.Semaphore;

import static act05.Main.Saldo;

public class Extraccion extends Thread {

    protected Semaphore finhilo;
    private int cantidad;

    public Extraccion(Semaphore finhilo, int cantidad) {
        this.finhilo = finhilo;
        this.cantidad=cantidad;
    }

    @Override
    public void run(){
        Saldo-=cantidad;
        System.out.println(cantidad+" euros extraidos correctamente");
        try {
            sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.finhilo.release();

    }
}
