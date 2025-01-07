public class Test {  
  
  public static void main(String[] args) {                                      
   
    int[] test = Toolbox.makeDesortedArray(500000);
    
    long zeit;
    zeit = System.currentTimeMillis();
    
    //Toolbox.printArray(test);
    
    //optimierterqs.quicksort(test);
    QuickSort.quicksort(test, 0, test.length-1);
    
    //System.out.println(Toolbox.isSorted(test));
    //Toolbox.printArray(test);
    
    zeit = System.currentTimeMillis() - zeit;
    System.out.println("Benötigte Zeit: " + zeit + " Millisekunden");  
  }
  
} 
