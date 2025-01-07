import java.util.ArrayList;
import java.util.Random;

public class Map{

    public Tile[][] map;
    private String[] biomes = {"wald", "grasland", "berge", "moor"};
    private Random random = new Random();
    private boolean[][] visited;
    private int spielerX, spielerY;

    ////////Dieser code wurde (größtenteils) von Chatgpt generiert////////
    
    public Map(int size, int anzahlDörfer){
        map = new Tile[size][size];
        visited = new boolean[size][size];
        spielerX = (int)(map.length/2);
        spielerY = (int)(map.length/2);

        // Fill the map with biome clusters
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if (!visited[i][j]) {
                    String biome = biomes[random.nextInt(biomes.length)];
                    int clusterSize = 2 + random.nextInt(6); // Cluster size between 2 and 7
                    createBiomeCluster(i, j, biome, clusterSize);
                }
            }
        }
        //Dörfer hinzufügen
        for (int i = 0; i < anzahlDörfer; i++) {
            int x = (int)(Math.random()*map.length);
            int y = (int)(Math.random()*map.length);

            if(map[x][y].getBiome() == "dorf" || x == 0 || y == 0){i--;}
            else{
                map[x][y] = new Dorf(x, y);
            }
        }
          

    }
    // Create a cluster of a given size with the same biome starting from a given tile
    private void createBiomeCluster(int startX, int startY, String biome, int size) {
        ArrayList<int[]> toVisit = new ArrayList<>();
        toVisit.add(new int[]{startX, startY});

        int clusterCount = 0;

        while (!toVisit.isEmpty() && clusterCount < size) {
            int[] current = toVisit.remove(0);
            int x = current[0];
            int y = current[1];

            // If the tile is out of bounds or already visited, skip it
            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || visited[x][y]) {
                continue;
            }

            // Assign biome to this tile
            map[x][y] = new Tile(x, y, biome);
            visited[x][y] = true;
            clusterCount++;

            // Add neighboring tiles (north, south, east, west) to the list to visit
            toVisit.add(new int[]{x - 1, y}); // North
            toVisit.add(new int[]{x + 1, y}); // South
            toVisit.add(new int[]{x, y - 1}); // West
            toVisit.add(new int[]{x, y + 1}); // East
        }
    }

    ////////////////

    public void printMap(){
        char[][] printArr = new char[map.length][map.length];
        for (int i = 0; i < printArr.length; ++i) {
            for (int j = 0; j < printArr[i].length; ++j) {
                printArr[i][j] = map[i][j].getBiome().charAt(0);
            }
        }
        String print = "";
        for (int i = 0; i < printArr.length; ++i) {
            for (int j = 0; j < printArr[i].length; ++j) {
                //print = print + printArr[i][j] + " ";
                if((i == spielerY) && j == spielerX)
                {print = print + (Tools.ANSI_RED_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                }else if(map[i][j].getBiome() == "dorf"){
                    print = print + (Tools.ANSI_BLUE_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                }else{
                    switch (printArr[i][j]) {
                        case 'w': //wald
                            print = print + (Tools.ANSI_GREEN_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                            break;
                        case 'g': //grasland
                            print = print + (Tools.ANSI_YELLOW_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                            break;
                        case 'b': //berge
                            print = print + (Tools.ANSI_WHITE_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                            break;
                        case 'm': //flussregion
                            print = print + (Tools.ANSI_CYAN_BACKGROUND + /*printArr[i][j] +*/"  "+ Tools.ANSI_RESET);
                            break;
                    }
                }
                
            }
            print = print + "\n";
        }
        System.out.println(print);
    }

    public void printLegende(){
        System.out.println(Tools.ANSI_RED_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Spieler");
        System.out.println(Tools.ANSI_BLUE_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Dorf");
        System.out.println();
        System.out.println(Tools.ANSI_GREEN_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Wald");
        System.out.println(Tools.ANSI_YELLOW_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Grasland");
        System.out.println(Tools.ANSI_WHITE_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Bergregion");
        System.out.println(Tools.ANSI_CYAN_BACKGROUND + "  "+ Tools.ANSI_RESET + " = Flussregion");
    }

    //Spieler position
    public int getSpielerX(){
        return spielerX;
    }
    public int getSpielerY(){
        return spielerY;
    }

    public void setSpielerX(int x){
        spielerX = spielerX + x;
    }
    public void setSpielerY(int y){
        spielerY = spielerY + y;
    }
    
    
}



