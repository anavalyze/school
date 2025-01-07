//soll eine main quest erstellen die zum gewinnen des spiels führt
//soll außerdem nebenquests erstellen die den spieler mit z.B. Items belohnen
//Questbuch zum einsehen akuteller Quests??

public class Quest {
    String name;
    String beschreibung;
    NPC questGeber;
    boolean erfüllt;

    public Quest(String name, String beschreibung, NPC questGeber){
        this.name = name;
        this.beschreibung = beschreibung;
        this.questGeber = questGeber;
        erfüllt = false;
    }
}
