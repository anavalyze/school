public class Monster extends NPC{
  
  // Attribute des Monsters
  private int leben;
  private int staerke;            
  private String name;
  
  
  
  // Ein zweiter Konstruktor, mit dem man auch Monster mit eigenen Werten anlegen kann
  public Monster(String name, int leben, int staerke){
    super(name, leben, staerke);
  }
  
  // Hier beginnen die weiteren Methoden der Klasse
  public void setLeben (int newLeben){
    if (newLeben>=0) {
      leben = newLeben;
    } else {
      leben = 0;
    }
  }
  
  public int getLeben (){
    return leben;  
  }

  public boolean nimmSchaden (int schaden){
    if (schaden<leben) {
      leben = leben - schaden;
      return true;
    } else {
      leben = 0;
      return false;
    }
  }
  
  public void setStaerke (int newStaerke){
    if (newStaerke>=1) {
      staerke = newStaerke;
    } else {
      staerke = 1;
    }
  }
                
  public int getStaerke (){
    return staerke;
  }  
  
  public void setName (String newName){
    name = newName;
  }
  
  public String getName (){
    return name;
  }
 


  
  
  // Platz für eure eigenen Methoden ...
  
  
}
