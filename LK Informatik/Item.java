public class Item {
    private String name;
    private int wert;
    private String typ;
    private int schaden;
    private int schutz;

    public Item(String name, int wert, String typ, int schaden, int schutz) {
        this.name = name;
        this.wert = wert;
        this.typ = typ;
        this.schaden = schaden;
        this.schutz = schutz;
    }

    //Getter

    public String getName() {
        return name;
    }

    public int getWert() {
        return wert;
    }

    public String getTyp() {
        return typ;
    }

    public int getSchaden() {
        return schaden;
    }

    public int getSchutz() {
        return schutz;
    }
   
    //Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public void setSchutz(int schutz) {
        this.schutz = schutz;
    }
    
}