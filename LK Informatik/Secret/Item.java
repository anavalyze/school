public class Item {
    private String name;
    private int wert;
    private String typ;
    private int schaden;
    private int schutz;

    public Item(String newName, int newWert, String newTyp, int newSchaden, int newSchutz){
        name = newName;
        wert = newWert;
        typ = newTyp;
        schaden = newSchaden;
        schutz = newSchutz;
    }

    public String getName (){
        return name;
    }
     
    public void setName(String newName){
        name = newName;
    }
    
    public int getWert(){
        return wert;
    }

    public void setWert(int newWert){
        wert = newWert;
    }

    public String getTyp(){
        return typ;
    }

    public int getSchaden(){
        return schaden;
    }

    public int getSchutz(){
        return schutz;
    }

    
}
