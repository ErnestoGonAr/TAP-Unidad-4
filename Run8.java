public class Run8 {

  public static void main(String[] args) {
    Runnable tarea = () -> {
      String nombreHilo = Thread.currentThread().getName();
      System.out.println("Hola " + nombreHilo);
    };

    tarea.run();

    Thread hilo1 = new Thread(tarea);
    hilo1.start();

    Thread hilo2 = new Thread(tarea);
    hilo2.start();

    Thread hilo3 = new Thread(tarea);
    hilo3.start();

    Thread hilo4 = new Thread(tarea);
    hilo4.start();

    System.out.println("Liiistooo");
  }

}
