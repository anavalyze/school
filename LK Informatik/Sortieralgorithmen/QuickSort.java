public class QuickSort {
  
  public static void quicksort (int[] liste, int untereGrenze, int obereGrenze) {
    int links = untereGrenze;
    int rechts = obereGrenze;
    int pivot = liste[((untereGrenze + obereGrenze)/2)];
    do {
      while (liste[links] < pivot) { 
        links = links + 1;
      }
      while (pivot < liste[rechts]) { 
        rechts = rechts - 1;
      }
      if (links <= rechts) {
        int ablage = liste[links];
        liste[links] = liste[rechts];
        liste[rechts] = ablage;
        links = links + 1;
        rechts = rechts - 1;
      } 
    } while (links <= rechts);
    if (untereGrenze < rechts) {
      quicksort(liste, untereGrenze, rechts);
    }
    if (links < obereGrenze) {
      quicksort(liste, links, obereGrenze);
    } 
  }
  
} 
