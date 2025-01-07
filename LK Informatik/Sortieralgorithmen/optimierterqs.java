
    
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class  optimierterqs{


    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            // Berechne den Pivot-Index
            int pivotIndex = partition(array, low, high);
            // Rekursiv linke und rechte Teile sortieren
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Berechne den Pivot-Wert basierend auf dem Durchschnitt mehrerer Elemente
        int pivot = calculatePivot(array, low, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static int calculatePivot(int[] array, int low, int high) {
        int size = high - low + 1;

        int sampleSize;
        if (size > 10000) {
            sampleSize = 100;
        } else if (size > 1000) {
            sampleSize = 10;
        } else {
            sampleSize = 1; // Standard Quicksort-Pivot-Auswahl
        }

        if (sampleSize == 1) {
            return array[high]; // Standardmäßig den letzten Wert als Pivot wählen
        }

        // Zufällige Stichprobe von sampleSize Elementen erstellen
        List<Integer> sample = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            int randomIndex = low + (int) (Math.random() * size);
            sample.add(array[randomIndex]);
        }

        // Durchschnitt der Stichprobe berechnen
        int sum = 0;
        for (int num : sample) {
            sum += num;
        }
        return sum / sampleSize;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Hauptmethode zum Testen
    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Unsortiertes Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quicksort(array);

        System.out.println("\nSortiertes Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}


