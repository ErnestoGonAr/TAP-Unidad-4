public class SleepMessagesIn{

  public static void main(String[] args) {
    String importantInfo[] = {
      "Muy cerca del ocaso, yo te bendigo, vida",
      "porque nunca me diste ni esperanza fallida",
      "ni trabajos injustos, ni pena inmerecida",
      "porque veo al final de mi rudo camino",
      "que yo fui el arquitecto de mi propio destino"
    };

    for(int i = 0;i< importantInfo.length;i++){
      try{
        Thread.sleep(4000);
      }catch(InterruptedException e){
        //We've beeen interrupted: no more messages-
        return;
      }
      //Print a message
      System.out.println(importantInfo[i]);
    }
  }

}
