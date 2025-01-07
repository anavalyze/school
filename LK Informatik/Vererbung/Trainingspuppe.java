public class Trainingspuppe {
    private int leben;
    private Rüstung rüstung;

    public Trainingspuppe(int leben, Rüstung rüstung) {
        this.leben = leben;
        this.rüstung = rüstung;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public Rüstung getRüstung() {
        return rüstung;
    }

    public void setRüstung(Rüstung rüstung) {
        this.rüstung = rüstung;
    }
}