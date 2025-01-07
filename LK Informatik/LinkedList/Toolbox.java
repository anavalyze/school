import java.util.Arrays;
import java.util.Random;

public class Toolbox {
  // Sammlung einiger einfacher Hilfsmethoden zur Arbeit mit int-Arrays

  public static void deSortArray(int[] array) {
    // Bringt die Einträge des übergebenen int-Arrays in eine zufällige Reihenfolge.
    int temp;
    int index;
    Random zufall = new Random();
    for(int i = 0; i < array.length; i++) {
      index = zufall.nextInt(array.length);
      temp = array[i];
      array[i] = array[index];
      array[index] = temp;
    }
  }
  
  public static int[] makeSortedArray(int laenge) {
    // Erzeugt ein sortiertes int-Array mit der übergebenen Länge.
    // Jede Stelle des Arrays enthält als Wert ihren Index + 1.
    int[] array = new int[laenge];
    for (int i = 0; i < array.length; i++) {
      array[i] = i+1;
    }
    return array;
  }
  
  public static int[] makeDesortedArray(int laenge) {
    // Erzeugt ein unsortiertes int-Array mit der übergebenen Länge.
    // Die enthaltenen Werte reichen von 1 bis zur übergebenen Länge.
    // Kein Wert tritt doppelt auf.
    int[] array = makeSortedArray(laenge);
    deSortArray(array);
    return array;
  }
  
  public static void printArray(int[] array) {
    // Gibt das übergebene int-Array in der Konsole aus.
    // Achtung: Diese Methode ist für kleine Arrays gedacht.
    // Für große Arrays ist sie eher unübersichtlich und langsam.
    System.out.println(Arrays.toString(array));
  }
  
  public static boolean isSorted(int[] array) {
    // Prüft ob das übergebene int-Array korrekt sortiert ist und liefert
    // das Ergebnis der Überprüfung als Wahrheitswert zurück.
    boolean sorted = true;
    for (int i = 0; i < array.length-1; i++) {
      if (array[i] > array[i+1]) {
        sorted = false;
        break;
      }
    } 
    return sorted;
  }
  
}
