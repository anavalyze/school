public class Trank extends Item{
    private String effektTyp;
    private int effektZahl;
    

    public Trank(String name, int wert){
        super(name, wert);
        switch (name) {
            case "Heiltrank":
                effektTyp = "Heilung";
                effektZahl = 30;
                break;
            case "Gifttrank":
                effektTyp = "Schaden";
                effektZahl = 30;
                break;
            default:
                effektTyp = "keiner";
                effektZahl = 0;
                break;
        }
    }

    public Trank(String name, int wert, String effektTyp, int effektZahl){
        super(name, wert);
        this.effektTyp = effektTyp;
        this.effektZahl = effektZahl;
    }
    
    public int getEffektZahl(){
        return effektZahl;
    }

    public String getEffektTyp(){
        return effektTyp;
    }
}