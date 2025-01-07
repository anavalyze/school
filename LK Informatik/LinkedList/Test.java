public class Test {
    public static void main(String[] args) {
        
        List liste = new List();

        int[] test = Toolbox.makeDesortedArray(20);

        for (int i : test) {
            liste.addLast(i);
        }


        long zeit;
        zeit = System.currentTimeMillis();

        liste.printAll();
       
        liste.newSort();
        
        //liste.isSorted();
        liste.printAll();
        zeit = System.currentTimeMillis() - zeit;
        System.out.println("Benötigte Zeit: " + zeit + " Millisekunden");  





        
    }
}
