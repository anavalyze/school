public class Held {
    private String name;
    private int leben;
    private Waffe waffe;

    public Held(String name, int leben, Waffe waffe) {
        this.name = name;
        this.leben = leben;
        this.waffe = waffe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public Waffe getWaffe() {
        return waffe;
    }

    public void setWaffe(Waffe waffe) {
        this.waffe = waffe;
    }

    
}