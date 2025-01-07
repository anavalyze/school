public class Person implements Sortierbar<Person>{  // <-- Das Interface "Sortierbar" wird von der Klasse implementiert
    private String vorname;
    private String nachname;
  
  // Konstruktor
    public Person(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }
  
  // get-/set-Methoden
    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
  
  // Methode zur Ausgabe einer Person auf dem Bildschirm
    public String toString() {
        return "Person {Vorname = '" + vorname + "', Nachname = '" + nachname + "'}";
    }
  
  // Umsetzung der Vorgaben des Interfaces
    public int vergleichen(Person vergleichsElement) {
        
    // Hier muss ihre Umsetzung der Methode "vergleichen" eingefügt werden.
    // Lesen Sie dazu zuerst die in dem Interface angegebenen Anforderungen
    // an die Methode. überlegen Sie sich anschließend, nach welchem Kriterium man
    // zwei Personen vergleichen (also in eine geordnete Reihenfolge bringen) kann.
    // Tip: Wie man Strings alphabetisch ordnet/vergleicht, finden sie sicher
    // schnell durch eine Suche im Internet heraus.
        if(this.nachname.compareTo(vergleichsElement.nachname) == 0){
          if(this.vorname.compareTo(vergleichsElement.vorname) == 0){
            return 0;
          }else{
            if(this.vorname.compareTo(vergleichsElement.vorname) > 0){
              return 1;
            }else{
              return -1;
            }
          }
        }else{
          if(this.nachname.compareTo(vergleichsElement.nachname) > 0){
            return 1;
          }else{
            return -1;
          }
        }
    
    }
}
