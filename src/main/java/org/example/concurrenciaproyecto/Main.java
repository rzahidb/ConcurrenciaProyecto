package org.example.concurrenciaproyecto;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Caja caja = new Caja();

        Runnable vendedor1 = () -> procesarVentas ("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas ("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas ("Vendedor 3", caja);

        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("----------Inicio del proceso de ventas--------");


        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("\n-------Termina proceso de ventas-------");
        System.out.println("\nCantidad de ventas: "+ caja.getCantidadVentas());
        System.out.println("\nTotal recaudado: C$" + caja.getTotalRecaudado());
    }

    private static void procesarVentas(String vendedor, Caja caja) {
        for(int i=1; i <= 50; i++){
            try{
                Thread.sleep(1000);
                caja.registrarVentas(vendedor, 100);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido.");
                return;
            }
        }
    }
}