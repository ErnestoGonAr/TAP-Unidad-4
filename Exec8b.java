import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exec8b {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    Runnable t = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello "+threadName);
    };

    executor.submit(t);

    try{
      System.out.println("Arrempt to shutdown executor");
      executor.shutdown();
      executor.awaitTermination(5,TimeUnit.SECONDS);
    } catch(InterruptedException e) {
      System.err.println("Task interrupted");
    }
    finally {
      if(!executor.isTerminated()){
        System.err.println("Cancel non-finished task");
      }
      executor.shutdownNow();
      System.out.println("Shutdown finished");
    }
  }

}
