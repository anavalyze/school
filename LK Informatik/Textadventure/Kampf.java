import java.util.Scanner;

public class Kampf {

    public static void kamp(Held spieler, Monster monster){
    System.out.println("Du begegnest einem " + monster.getName() + "!");
    Scanner scKampf = new Scanner(System.in);
    boolean kampf = true;
    while (kampf){
      System.out.println("Leben Spieler: " + spieler.getLeben() + " Leben Monster: " + monster.getLeben()); 
      Abenteuer.wait(500);
      System.out.println("Was wirst du tun?");
      Abenteuer.wait(500);
      System.out.println("1: angreifen     2: item     3: rüstung ändern     4: flüchten");
      String kampfEingabe1 = scKampf.nextLine();
      switch (kampfEingabe1) {
        case "1":
        case "angreifen":
          boolean angriff = true;
          while(angriff){
            System.out.println("Womit möchtest du angreifen?");
            Abenteuer.wait(500);
            System.out.println(Inventar.print(spieler.getAttackablesNames()));
            int kampfEingabe2 = scKampf.nextInt();
            kampfEingabe2--;
            if(kampfEingabe2 < 0 || kampfEingabe2 >= spieler.getAttackables().length){
              System.out.println("Gib einer deiner Waffen als Zahl an!");
            }else{
              if(spieler.getAttackables()[kampfEingabe2] instanceof Waffe){
                System.out.println("Du greifst mit deinem " + spieler.getAttackables()[kampfEingabe2].getName() + " an und machst " + ((Waffe)spieler.getAttackables()[kampfEingabe2]).getSchaden() + " schaden!");
                Abenteuer.wait(500);
                if(monster.nimmSchaden(((Waffe)spieler.getAttackables()[kampfEingabe2]).getSchaden())){
                  System.out.println("Das Monster hat " + monster.getLeben() + " Leben übrig.");
                }else{
                  System.out.println("Du hast den " + monster.getName() + " besiegt!");
                  kampf = false;
                }
              }else if(spieler.getAttackables()[kampfEingabe2] instanceof Trank){
                System.out.println("Du wirfst deinen " + spieler.getAttackables()[kampfEingabe2].getName() + " auf den " + monster.getName());
              }
              
              angriff = false;
            }
          }
          break;
        case "2":
        case "item":

          break;
        case "3":
        case "rüstung ändern":
          
          break;
        case "4":
        case "flüchten":
          int flüchten = (int)Math.random()*2;
          if(flüchten < 1){
            System.out.println("Deine Flucht ist fehlgeschlagen!");
          }else{
            System.out.println("Du flüchtest erfolgreich!");
            kampf = false;
          }
          break;
        default:
          System.out.println("Bitte gib eine der vier Optionen als Antwort!");
          break;
      }
      scKampf.nextLine(); //Scanner buffer leeren sonst macht er faxen
    }
    scKampf.close();
  }


}
