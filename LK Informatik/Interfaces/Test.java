public class Test{
  public static void main(String args[]){

    Person person1 = new Person("Tom", "Jones");
    Person person2 = new Person("James", "Brown");
    Person person3 = new Person("Mira", "Sulivan");
    Person person4 = new Person("Anna", "Wechsler");
    Person person5 = new Person("Enzo", "Sulivan");
    Person person6 = new Person("Carlos", "Sulivan");
    
    
    // Wenn sie das Interface korrekt implementiert haben, dann sollte Folgendes funktionieren ...
    if (person1.vergleichen(person2) == 1) {
      System.out.println("Die erste Person muss in alphabetischer Reihenfolge hinter der zweiten Person stehen.");
    } else if (person1.vergleichen(person2) == -1) {
      System.out.println("Die erste Person muss in alphabetischer Reihenfolge vor der zweiten Person stehen.");  
    } else {
      System.out.println("Beide Personen haben den selben Namen.");  
    }

    
    // Außerdem wird das Sortieren der Personen getestet: 
    
    // zuerst werden die Personen in einer statischen Liste (Array) zusammengefasst.                                    
    Person[] liste = new Person[6];
    liste[0] = person1;
    liste[1] = person2;
    liste[2] = person3;
    liste[3] = person4;
    liste[4] = person5;
    liste[5] = person6;
    
    // Dann wird die Liste in unsortiertem Zustand ausgegeben.
    System.out.println("So sieht die Liste vor dem Sortieren aus:");
    for (int i = 0; i < liste.length; i++) {
      System.out.println(liste[i]);
    }
    
    // Nun folgt ein simpler BubbleSort der Liste mit Hilfe der vergleichen-Methode.
    Person ablage; 
    
    for (int i = 0; i < liste.length; i++) {                
      for (int j = 0; j < liste.length-1-i; j++) {
        if (liste[j].vergleichen(liste[j+1]) == 1) {                      
          ablage = liste[j];                                                        
          liste[j] = liste[j + 1];                                                     
          liste[j + 1] = ablage;                                                    
        }
      }
    }
    
    // Und zum Schluss wird die sortierte Liste ausgegeben.
    System.out.println("So sieht die Liste nach dem Sortieren aus:");
    for (int i = 0; i < liste.length; i++) {
      System.out.println(liste[i]);
    }
    
  }
}
