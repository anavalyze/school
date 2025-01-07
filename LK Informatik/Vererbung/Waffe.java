public class Waffe extends Gegenstand {
    private int schaden;
    private int haltbarkeit;

    public Waffe(String name, String beschreibung, int schaden, int haltbarkeit){
        super(name, beschreibung);
        this.schaden = schaden;
        this.haltbarkeit = haltbarkeit;
    }


    @Override
    public String info() {
        return super.info() + " (Schaden: " + schaden + ", Haltbarkeit: " + haltbarkeit + ")";
    }

    public int getSchaden() {
        return schaden;
    }

    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public int getHaltbarkeit() {
        return haltbarkeit;
    }

    public void setHaltbarkeit(int haltbarkeit) {
        this.haltbarkeit = haltbarkeit;
    }

    public int schadenBerechnen() {
        int x = Math.max(0, Math.min(10, schaden + (int)(Math.random()*5)-2));
        return x;
    }
}