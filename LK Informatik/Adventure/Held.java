public class Held extends Person {
    // Attribute fur den Held
    private int coins;
    private int erfahrung;
    private int level;
    private int schild;
    private String aktiveFahigkeit;
    private Dorfbewohner dorfbewohner;
    private String schwierigkeit;

    private double coinFaktor = 1.0;
    private double erfFaktor = 1.0;
    int rustungLvl = 1;
    int waffeLvl = 1;

	int[] rustungen = {0, 15, 30, 60, 80, 80};
	int[] preisR = {20, 100, 300, 600, 1200, 1800};
	int[] erfR = {0, 0, 300, 700, 1500, 2500};

	int[] waffen = {0, 2, 3, 6, 9, 9};
	int[] preisW = {20, 100, 300, 600, 1200, 1800};
	int[] erfW = {0, 0, 300, 700, 1500, 2500};

    // Konstruktor
    public Held(int leben, String name, int schaden, int ausweichen, int kritisch, int coins, int erfahrung, int level, int schild, Dorfbewohner dorfbewohner) {
        super(leben, name, schaden, ausweichen, kritisch); // Aufruf des Konstruktors der Basisklasse
        this.coins = coins;
        this.erfahrung = erfahrung;
        this.level = level;
        this.schild = schild;
        this.dorfbewohner = dorfbewohner;
    }

	// get und set Methoden.
	public void setCoins(int coins){    
		this.coins = coins;  
	}  
	public int getCoins(){    
		return this.coins;  
	}

	public void setCoinFaktor(double coinFaktor) {
		this.coinFaktor = coinFaktor;
	}
	public double getCoinFaktor() {
		return coinFaktor;
	}

	public void setErfahrung(int erfahrung) {
		this.erfahrung = erfahrung;
	}
	public int getErfahrung() {
		return this.erfahrung;
	}

	public void setErfFaktor(double erfFaktor) {
		this.erfFaktor = erfFaktor;
	}
	public double getErfFaktor() {
		return this.erfFaktor;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}

	public void setSchild(int schild) {
		this.schild = schild;
	}
	public int getSchild() {
		return this.schild;
	}

	public void setSchwierigkeit(String schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	public String getSchwierigkeit() {
		return schwierigkeit;
	}
	
	public String getAktiveFahigkeit() {
		return this.aktiveFahigkeit;
	}
	public void setAktiveFahigkeit(String fahigkeit) {
		this.aktiveFahigkeit = fahigkeit;
	}
	
	public Dorfbewohner getDorfbewohner() {
		return dorfbewohner;
	}
	public void setDorfbewohner(Dorfbewohner dorfbewohner) {
		this.dorfbewohner = dorfbewohner;
	}

	// Fahigkeiten
	public void deaktiviereAktiveFahigkeit() {
		if (aktiveFahigkeit != null) {
			switch (aktiveFahigkeit) {
				case "Steinhaut":
					setLeben(getLeben() - 50);
					break;
				case "Flinke Fuße":
					setAusweichen(getAusweichen() - 25);
					break;
				case "Schicksalsschlag":
					setKritisch(getKritisch() - 20);
					break;
				case "Kraft der Titanen":
					setSchaden(getSchaden() - 15);
					break;
				case "Gieriger Griff":
					setCoinFaktor(1.0);
					break;
				case "Lehrmeister":
					setErfFaktor(1.0);
					break;
				default:
			}
			this.aktiveFahigkeit = null;
		}
	}

	// Rustung und Waffe
	public int[] rustungWerte(int level) {
		// uberprufen, ob das Level gultig ist
		if (level < 1 || level >= rustungen.length) {
			return null;
		}
		// Erstellen des Ruckgabe-Arrays mit Rustung, Preis, Erfahrung die benotigt wird, dem aktuellen Level und dem maximalen Level
		int[] werte = {rustungen[level], preisR[level - 1], erfR[level - 1], level, rustungen.length - 1};
		return werte;
	}

	public int[] waffeWerte(int level) {
		// uberprufen, ob das Level gultig ist
		if (level < 1 || level >= waffen.length) {
			return null;
		}
		// Erstellen des Ruckgabe-Arrays mit Rustung, Preis, Erfahrung die benotigt wird, dem aktuellen Level und dem maximalen Level
		int[] werte = {waffen[level], preisW[level - 1], erfW[level - 1], level, waffen.length - 1};
		return werte;
	}

}