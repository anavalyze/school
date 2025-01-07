public class Rüstung extends Gegenstand{
    private int schutzwert;
    private String material;

    public Rüstung(String name, String beschreibung, int schutzwert, String material) {
        super(name, beschreibung);
        this.schutzwert = schutzwert;
        this.material = material;
    }

    public int getSchutzwert() {
        return schutzwert;
    }

    public void setSchutzwert(int schutzwert) {
        this.schutzwert = schutzwert;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
