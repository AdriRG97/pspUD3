package act05;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {


static int Saldo=1000;

    public static void main(String[] args) {
        Semaphore finHilo = new Semaphore(1);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                finHilo.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int opcion = 0;

            System.out.println("Bienvenido a tu banco");
            while (opcion < 1 || opcion > 3) {
                System.out.println("Tienes " + Saldo + " Euros");
                System.out.println("1. Extraer dinero");
                System.out.println("2. Depositar dinero");
                System.out.println("3. Salir");
                opcion = scanner.nextInt();
            }
            int cantidad = 0;
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuanto desea extrer?");
                    cantidad = scanner.nextInt();
                    if (cantidad > Saldo) {
                        System.out.println("No puedes extraer mas dinero del que tienes (" + Saldo + ")");
                        finHilo.release();
                        break;
                    }
                    Extraccion extraccion = new Extraccion(finHilo, cantidad);
                    extraccion.start();
                    break;
                case 2:
                    System.out.println("¿Cuanto desea depositar?");
                    cantidad = scanner.nextInt();
                    Deposito deposito = new Deposito(finHilo, cantidad);
                    deposito.start();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }
    }
}
