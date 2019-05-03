package sprites;

/**
 * @version 1.0
 * @author Benjamin
 */
public class Sprite {
    private final int SIZE;
    private int x, y;
    public int[] pixlels;
    private SpriteSheet sheet;

    public Sprite(int SIZE, int x, int y, SpriteSheet sheet) {
        this.SIZE = SIZE;
        pixlels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
    }
    
    private void load(){
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixlels[x + y * SIZE] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getSize()];
            }
        }
    }
    
    
    
    
}
