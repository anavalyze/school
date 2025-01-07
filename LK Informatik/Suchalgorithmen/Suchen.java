import java.io.*;
import java.util.Arrays;

class Suchen{
  private static int[] schuelerliste;
  public int[] liste = generateList(100000);
  
  //Konstruktor
  public Suchen() throws IOException {
    schuelerliste = new int[80]; 
    // Einlesen der Schülernummern aus dem Textdokument:
    FileReader reader = new FileReader("data.txt");
    BufferedReader inBuffer = new BufferedReader(reader);
    for (int i = 0; i<schuelerliste.length; i++) {
      schuelerliste[i] = Integer.parseInt(inBuffer.readLine());
    }
    inBuffer.close();
  } 
  
  // Übliche get-Methoden
  public int[] getSchuelerliste(){
    return schuelerliste;
  }  
  
  public int getEintrag(int stelle){
    return schuelerliste[stelle];
  }

  
   public int lineareSuche(int schuelernummer){
    int a = 0;
    int[] arr = liste;
    for (int i : arr) {
      a++;
      if(i == schuelernummer){return a;}
    }
    return -1;     // <-- steht aktuell nur hier, damit der Compiler nicht sofort meckert
  }

  public int[] generateList(int length){
    int[] liste = new int[length];
    for (int i : liste) {
      if(i == 0){liste[i] = 1;}else{
      liste[i] = liste[i-1] + (int)(Math.random() * 10);}
    }
    return liste;
  }


  public int binäreSuche(int schuelernummer) {
    int[] arr = liste;
    Arrays.sort(arr); 
    int i1 = 0;
    int i2 = arr.length - 1;
    int rückgabe = -1; 

    while (i1 <= i2) {  
        int mitte = (i1 + i2) / 2;  

        if (arr[mitte] == schuelernummer) {  
            rückgabe = mitte;
            break; 
        } else if (schuelernummer < arr[mitte]) {
            i2 = mitte - 1;
        } else {  
            i1 = mitte + 1;
        }
    }
    System.out.println(arr[rückgabe]);
    return rückgabe;
}


  
  public static void main(String args[]){
    try {
      Suchen testsuche = new Suchen();
      int gesuchterWert = 500;               // Der in der Liste zu suchende Wert (kann hier je nach Wunsch verändert werden)
      
      long t = System.currentTimeMillis();   // Beginn der Zeitmessung
      
      // Aufruf des Suchalgorithmus
      int gefundenAnStelle = testsuche.binäreSuche(gesuchterWert);
      

      t = System.currentTimeMillis() - t;    // Ende der Zeitmessung

      // Ausgabe des Ergebnisses
      System.out.println("Der gesuchte Wert " + gesuchterWert + " wurde an Stelle " + gefundenAnStelle + " gefunden. Die Suche benötigte " + t + " Millisekunden.");  

    } catch(IOException e) {System.out.println("Fehler beim Öffnen der Datei");}
  }
}
