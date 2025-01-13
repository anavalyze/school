public class Person {
    // Gemeinsame Attribute
    protected int leben;
    protected String name;
    protected int schaden;
    protected int ausweichen;   // Wahrscheinlichkeit, dass die Person einer Attacke ausweicht.
    protected int kritisch;     // Wahrscheinlichkeit kritisch zu treffen.

    protected int rustungLvl = 1;
    protected int waffeLvl = 1;

    // Konstruktor
    public Person(int leben, String name, int schaden, int ausweichen, int kritisch) {
        this.leben = leben;
        this.name = name;
        this.schaden = schaden;
        this.ausweichen = ausweichen;
        this.kritisch = kritisch;
    }

    // getter und setter
    public int getLeben() {
        return leben;
    }
	public void setLeben(int leben){    
		this.leben = leben;
		if (this.leben < 0) { 
			this.leben = 0;
		}
	}  

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSchaden() {
        return schaden;
    }
    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public int getAusweichen() {
        return ausweichen;
    }
    public void setAusweichen(int ausweichen) {
        this.ausweichen = ausweichen;
    }

    public int getKritisch() {
        return kritisch;
    }
    public void setKritisch(int kritisch) {
        this.kritisch = kritisch;
    }

    public int getRustungLvl() {
		return rustungLvl;
	}
	public void setRustungLvl(int rustungLvl) {
		this.rustungLvl = rustungLvl;
	}

	public int getWaffeLvl() {
		return waffeLvl;
	}
	public void setWaffeLvl(int waffeLvl) {
		this.waffeLvl = waffeLvl;
	}

    // uberprufen, ob die Person noch lebt
    public boolean isAlive() {
        return leben > 0;
    }
    
    // Person nimmt Schaden
    public void nimmSchaden(int schaden) {
        if (this.leben > 0) {
            int effektiverSchaden = Math.max(schaden, 0);
            this.leben -= effektiverSchaden;
            if (this.leben < 0) {
                this.leben = 0;
            }
        }
    }
    
}