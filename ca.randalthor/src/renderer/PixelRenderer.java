/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import tile.Map;

/**
 *
 * @author Benjamin
 */
public class PixelRenderer {

    Screen window;
    private int[] pixels;
    private BufferedImage image;
    private Map map;

    public PixelRenderer(Screen window, Map map) {
        this.window = window;
        this.image = new BufferedImage(window.width, window.height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        this.map = map;
    }

    /**
     * the master render method for the pixel renderer
     * @param xOffset
     * @param yOffset 
     */
    public void render(int xOffset, int yOffset) {
        BufferStrategy bs = window.canvas.getBufferStrategy();
        if (bs == null) {
            window.canvas.createBufferStrategy(3);
            return;
        }
        clearPixels();
        renderPixels(xOffset, yOffset);
            
        Graphics g = bs.getDrawGraphics();
        {
            g.drawImage(image, 0, 0, window.canvas.getWidth(), window.canvas.getHeight(), null);
        }
        g.dispose();
        bs.show();
    }
    
    /**
     * @param xOffset
     * @param yOffset
     * used by the pixel renderer to Allow movement of tileBased maps onto the canvas
     */
    public void renderPixels(int xOffset, int yOffset){
        for (int y = 0; y < window.height; y++) {
            int yPlusOffset = y + yOffset;
            if (yPlusOffset < yOffset || yPlusOffset >= window.height + yOffset) break;
            for (int x = 0; x < window.width; x++) {
                int xPlusOffset = x + xOffset;
                if(xPlusOffset < xOffset || xPlusOffset >= window.width + xOffset) break;
                int tileIndex = (xPlusOffset / map.getTileSize() & map.getWidth() - 1) + (yPlusOffset / map.getTileSize() & map.getWidth() - 1) * map.getWidth();
                pixels[x + y * window.width ] = map.getTiles()[tileIndex].getColor();
            }
        }
    }
    
    private void clearPixels(){
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
