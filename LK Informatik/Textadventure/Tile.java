public class Tile {
    String biome;
    String[] biomes = {"wald", "grasland", "berge", "moor"};
    int x;
    int y;
    boolean betretbar;
    Monster monster;

    public Tile(int x, int y, String biome){
        this.biome = biome;
        this.x = x;
        this.y = y;
        this.betretbar = true;
        this.monster = null;
    }

    public Tile(int x, int y, boolean betretbar){
        this.biome = biomes[(int)Math.random()*4];
        this.x = x;
        this.y = y;
        this.betretbar = betretbar;
    }

    public void setBetretbar(boolean betretbar){
        this.betretbar = betretbar;
    }

    public void setBiome(String biome){
        this.biome = biome;
    }

    public String getBiome(){
        return biome;
    }

    public void setMonster(Monster monster){
        this.monster = monster;
    }

    public Monster getMonster(){
        return monster;
    }
}
