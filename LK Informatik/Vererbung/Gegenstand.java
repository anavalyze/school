public class Gegenstand {
    private String name;
    private String beschreibung;

    public Gegenstand(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public String info() {
        return name + ": " + beschreibung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}