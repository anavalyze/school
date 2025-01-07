public abstract class Inventar { 
    private Item[] inventar;

    public Inventar(int inventarLänge){
        inventar = new Item[inventarLänge];
    }


    public void setInventar (int inventarLoc, Item myItem){ //Setter für eine bestimmte Stelle im Inventar
        if(inventarLoc < 1 || inventarLoc > inventar.length){
          System.out.println("Fehler: Das Inventar des Spielers hat " + inventar.length + " Slots. Der erste Slot ist 1 (nicht 0).");
        }else{
          inventar[inventarLoc-1] = myItem;
        }
      }
      
      public Item getInventar (int inventarLoc){ //Gibt das Item eines bestimmten Slots zurück
        if(inventarLoc < 1 || inventarLoc > inventar.length){
          System.out.println("Fehler: Das Inventar des Spielers hat " + inventar.length + " Slots. Der erste Slot ist 1 (nicht 0).");
        }
        return inventar[inventarLoc-1];
      }
    
      public String[] getInventar(){ //Gibt den Namen jedes Items im Inventar als Array zurück
        String[] printArray = new String[inventar.length];
        for (int i = 0; i < inventar.length; i++) {
          if (inventar[i] == null){ //Sonst Nullpointerexception
            printArray[i] = " / "; //falls kein Item in dem Slot vorhanden ist, wird die korrespondierende Stelle im StringArray mit "/" gefüllt
          }else{
            printArray[i] = inventar[i].getName();
          }
        }
        return printArray; //StringArray wird nach vollenden der Schleife zurückgegeben
      }
    
      public String[] getAttackablesNames(){
        String[] tempArray = new String[inventar.length];
        int w = 0;
        for (int i = 0; i < inventar.length; i++) {
          if (inventar[i] instanceof Waffe || inventar[i] instanceof Trank){
            tempArray[w] = inventar[i].getName();
            w++;
          }
        }
        String[] rückgabe = new String[w];
        for(int i = 0; i < w; i++){
          rückgabe[i] = tempArray[i];
        }
        return rückgabe;
      }

      public Item[] getAttackables(){
        Item[] tempArray = new Item[inventar.length];
        int w = 0;
        for (int i = 0; i < inventar.length; i++) {
          if (inventar[i] instanceof Waffe || inventar[i] instanceof Trank){
            tempArray[w] = inventar[i];
            w++;
          }
        }
        Item[] rückgabe = new Item[w];
        for(int i = 0; i < w; i++){
          rückgabe[i] = tempArray[i];
        }
        return rückgabe;
      }

      public static String print(String[] myArray){
        String print = "";
        int w = 1;
        for (int i = 0; i < myArray.length; i++) {
          print = print + w + ": " + myArray[i] + " ";
            w++;
        }
        return print;
      }
      

}
