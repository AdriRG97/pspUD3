package act05;

import java.util.concurrent.Semaphore;

import static act05.Main.Saldo;

public class Deposito extends Thread {

    protected Semaphore finHilo;
    private int cantidad;

    public Deposito(Semaphore finHilo, int cantidad) {
        this.finHilo = finHilo;
        this.cantidad=cantidad;
    }

    @Override
    public void run(){
        Saldo+=cantidad;
        System.out.println(cantidad+" euros depositados correctamente");
        try {
            sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.finHilo.release();
    }
}
