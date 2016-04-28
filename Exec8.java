import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exec8 {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Runnable t = () ->  {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello " +threadName);
    };
    executor.submit(t);
    //sigue esperando por nuevas tareas
  }

}
