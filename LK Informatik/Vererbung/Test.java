public class Test{
    public static void main(String[] args){
        Waffe ast = new Waffe("Brüchiger Ast", "Zerbricht beim ersten Schlag", 10, 100);
        Rüstung jacke = new Rüstung("Jacke", "bietet leichten Schutz", 5, "leder");
        Trainingspuppe trainingspuppe = new Trainingspuppe(50, jacke);
        Held spieler = new Held("spieler", 50, ast);

        System.out.println(trainingspuppe.getLeben());
        System.out.println("angriff");
        trainingspuppe.setLeben(trainingspuppe.getLeben() - (spieler.getWaffe().schadenBerechnen() - trainingspuppe.getRüstung().getSchutzwert()));
        System.out.println(trainingspuppe.getLeben());
    }
}