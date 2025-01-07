public class Rüstung extends Item{

    private int schutz;
    
    public Rüstung(String name, int wert, int schutz){
        super(name, wert);
        this.schutz = schutz;
    }

    public int getSchutz(){
        return schutz;
    }

    public void setSchutz(int schutz){
        this.schutz = schutz;
    }
}
