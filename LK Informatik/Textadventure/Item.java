public class Item {
    private String name;
    private int wert;

    public Item(String name, int wert){
        this.name = name;
        this.wert = wert;
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
    
}
