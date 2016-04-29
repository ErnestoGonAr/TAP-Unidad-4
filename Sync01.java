import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

public class Sync01 {

  public static int count=0;

  public static void stop(ExecutorService executor){
    try{
      executor.shutdown();
      executor.awaitTermination(60,TimeUnit.SECONDS);
    }catch(InterruptedException e){
      System.err.println("Termiation interrupted");
    }
    finally{
      if(!executor.isTerminated()){
        System.err.println("Killin non-finished task");
      }
      executor.shutdownNow();
    }
  }

  public synchronized static void increment(){
    count = count + 1;
  }

  public static void main(String[] args) {
    Runnable t = () -> increment();
    ExecutorService executor = Executors.newFixedThreadPool(2);

    IntStream.range(0,10000).forEach(i ->  executor.submit(t));

    stop(executor);

    System.out.println(count);
  }

}
