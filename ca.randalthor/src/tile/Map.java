package tile;

import java.util.Random;

/**
 * @version 1.0
 * @author Benjamin
 */
public class Map {
    private Tile[] map;
    private int width, height, tileSize;
    

    public Map(int width, int height, int tileSize) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        RandomMapGen();
    }
    
    /**
     * @deprecated
     * Not intended for actual usage, just for debug use
     */
    private void RandomMapGen(){
        Random random = new Random();
        map = new Tile[width * height];
        for (int i = 0; i < map.length; i++) {
            map[i] = new Tile(random.nextInt(0xffffff));
        }
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public Tile[] getTiles(){
        return this.map;
    }
     public int getTileSize(){
         return this.tileSize;
     }
    
}
