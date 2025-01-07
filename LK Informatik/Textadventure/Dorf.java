public class Dorf extends Tile{
    
    String name;
    String[] names = {"Ascot", "Fortaare", "Caelkirk", "Airedale", "Ormskirk"};

    public Dorf(int x, int y){
        super(x, y, "dorf");
        this.name = names[(int)(Math.random()*5)];
    }
}
