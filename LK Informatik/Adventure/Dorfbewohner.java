// Klasse des Dorfbewohners
public class Dorfbewohner extends Person {

    // Variablendeklaration
    int rustungLvl = 1;
	int waffeLvl = 1;

    // Werte
    int[] rustungen = {0, 5, 8, 16, 22, 22};
    int[] preisR = {20, 100, 300, 600, 1200, 1800};
    int[] erfR = {0, 0, 300, 700, 1500, 2500};

    int[] waffen = {0, 1, 2, 3, 5, 5};
    int[] preisW = {20, 100, 300, 600, 1200, 1800};
    int[] erfW = {0, 0, 300, 700, 1500, 2500};

    // Konstruktor
    public Dorfbewohner(int leben, String name, int schaden, int ausweichen, int kritisch) {   
        super(leben, name, schaden, ausweichen, kritisch);
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