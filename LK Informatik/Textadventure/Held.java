public class Held extends Inventar{
  
  // Die Attribute des Helden werden angelegt.
  // Vorgegeben sind hier bereits Leben und Name, weitere Attribute müssen noch hinzugefügt werden
  private int leben;             
  private String name;
  int locX, locY;
  
  
  // Hier stehts der Konstruktor der Klasse    
  public Held(int leben, String name, int inventarLänge){
    super(inventarLänge);
    this.leben = leben;
    this.name = name;
    locX = 1;
    locY = 1;
    
  }
  
  // Hier beginnen die weiteren Methoden der Klasse
  public void setLeben (int newLeben){
    if (newLeben>=0) {
      leben = newLeben;
    } else {
      System.out.println("Fehler: Die Lebenspunkte des Helden können nicht auf einen Wert unter Null gesetzt werden.");
    }
  } 
  public int getLeben (){
    return leben;  
  }
  public void setName (String newName){
    name = newName;
  }
  public String getName (){
    return name;
  }

  /* 
  public int getLocX(){
    return locX;
  }
  public int getLocY(){
    return locY;
  }

  public void setLocX(int x){
    locX = x;
  }
  public void setLocY(int y){
    locY =  y;
  }*/
 
  
}