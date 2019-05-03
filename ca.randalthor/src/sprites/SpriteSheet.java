package sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @version 1.0
 * @author Benjamin
 */
public class SpriteSheet {
    private String path;
    private final int SIZE;
    private int[] pixels;
    
    /**
     * 
     * @param path path of image
     * @param SIZE size of image MUST BE SQUARE
     * @throws IOException if image failed to load
     */
    public SpriteSheet(String path, int SIZE) throws IOException {
        this.path = path;
        this.SIZE = SIZE;
        pixels = new int[SIZE * SIZE];
        load();
    }
    
    /**
     * used by SpriteSheet to load image from given path into pixel array, throws IOException when unable to load image from path.
     * @throws IOException 
     */
    private void load() throws IOException{
        BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
    }
    
    public int[] getPixels(){
        return this.pixels;
    }
    
   
}
