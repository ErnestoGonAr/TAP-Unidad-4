public class SimpleThreads {

  //Display a message, preceded by the name of the current thread
  static void threadMessage(String message){
    String threadName = Thread.currentThread().getName();
    System.out.format("%s: %s%n", threadName, message);
  }

  private static class MessageLoop implements Runnable {
    @Override
    public void run(){
      String importantInfo[] = {
        "Muy cerca del ocaso, yo te bendigo, vida",
        "porque nunca me diste ni esperanza fallida",
        "ni trabajos injustos, ni pena inmerecida",
        "porque veo al final de mi rudo camino",
        "que yo fui el arquitecto de mi propio destino"
      };
      try {
        for(int i=0;i<importantInfo.length;i++){
          //Pause for 4 seconds
          Thread.sleep(4000);
          //Print a message
          threadMessage(importantInfo[i]);
        }
      } catch(InterruptedException e){
        threadMessage("No he terminado puños, adios u,u");
      }
    }
  }

  public static void main(String[] args) {
    throws InterruptedException {
      //Delay, in miliseconds before
      //we interrupt MessageLoop
      //thread (default one hour)
      long patience = 100*60*60;

      //if command line argument
      //present, gives patience
      //in seconds
      if(args.length > 0){
        try{{
          patience = Long.parseLong(args[0])*1000;
        }catch(NumberFormatException e){
          System.err.println("El argumento debe ser entero");
          System.exit(1);
        }
      }

      threadMessage("Iniciando el hilo del ciclo de mensajes");
      long starTime = System.currentTimeMillis();
      Thread t = new Thread(new MessageLoop());
      t.start();

      threadMessage("Esperando que el hilo del civclo de mensajes termine su ciclo");
      //loop until MessageLoop
      //threads exist
      while(t.isAlive())
    }
  }

}
