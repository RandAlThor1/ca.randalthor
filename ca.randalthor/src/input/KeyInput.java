package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @version 1.0
 * @author Benjamin
 */
public class KeyInput implements KeyListener{

    private boolean[] keys = new boolean[655];
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("relased");
        keys[e.getKeyCode()] = false;
    }
    
    public boolean[] getKeys(){
        return this.keys;
    }
}
