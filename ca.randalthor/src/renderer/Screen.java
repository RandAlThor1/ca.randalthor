/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Benjamin
 */
public class Screen extends JFrame{
    final int height, width, scale;
    ScreenCanvas canvas;

    public Screen(int height, int width, int scale, String title) {
        this.height = height;
        this.width = width;
        this.scale = scale;
        canvas = new ScreenCanvas(new Dimension(width * scale, height * scale));
        
        this.setResizable(false);
        this.setTitle(title);
        this.add(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
