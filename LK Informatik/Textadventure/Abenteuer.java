import java.util.*;

public class Abenteuer {

  public static void wait(int ms)
{
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
}

  
  public static void main (String args[]){  
    System.out.println("Hallo Fremder. Willkommen in unserem bescheidenen Dorf. Wie ist lautet Name?");
    
    //Scanner
    Scanner sc = new Scanner(System.in);                                        
    String eingabe = sc.nextLine();                                             
    
    //Helden erstellen
    Held spieler = new Held(100, eingabe, 6);
    
    //------------------------------------------------------------ Das Abenteuer beginnt ... --------------------------------------------------------------------------------
    

    Waffe schwert = new Waffe("Schwert", 10, 10);
    Waffe bogen = new Waffe("Bogen", 30, 5);

    spieler.setInventar(2, bogen);
    spieler.setInventar(4, schwert);


    Monster rudolf = new Monster("rudolf", 40, 20);
    //Kampf.kamp(spieler, rudolf);
    Map map = new Map(15, 3);
    map.map[5][5].setMonster(rudolf);
    
    
    boolean gewonnen = false;
    while(!gewonnen){
      System.out.println("Was möchtest du tun?");
      String eingabe3 = sc.next();
    if(eingabe3.contains("norden") || eingabe3.contains("oben") ){
      map.setSpielerY(-1);
    }else if(eingabe3.contains("osten") || eingabe3.contains("rechts") ){
      map.setSpielerX(1);
    }else if(eingabe3.contains("sueden") || eingabe3.contains("unten") ){
      map.setSpielerY(1);
    }else if(eingabe3.contains("westen") || eingabe3.contains("links") ){
      map.setSpielerX(-1);
    }else if(eingabe3.contains("karte")){
      map.printMap();
    }else if(eingabe3.contains("legende")){
      map.printLegende();
    }

    if(map.map[map.getSpielerX()][map.getSpielerY()].getMonster() != null){
      Kampf.kamp(spieler, map.map[map.getSpielerX()][map.getSpielerY()].getMonster());
    }

    sc.nextLine();
    }
    sc.close();     
  } 
}
