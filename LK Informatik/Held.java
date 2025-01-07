public class Held{
  private int leben;               
  private String name;

  public Held(int newLeben, String newName){
    leben = newLeben;
    name = newName;
  }

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
}