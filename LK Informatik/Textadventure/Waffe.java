public class Waffe extends Item{

    private int schaden;
    
    public Waffe(String name, int wert, int schaden){
        super(name, wert);
        this.schaden = schaden;
    }

    public int getSchaden(){
        return schaden;
    }

    public void setSchaden(int schaden){
        this.schaden = schaden;
    }
}