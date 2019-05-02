package game;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Benjamin
 */
public class Loop implements Runnable {

    private final double loopsPerSecond;
    private int loopsLastSecond;
    private final String name;
    private boolean isLooping;
    private ArrayList<Activity> acts;
    private Thread thread;

    public Loop(double loopsPerSecond, String name) {
        this.loopsPerSecond = loopsPerSecond;
        this.name = name;
        acts = new ArrayList<>();
    }

    public void addActivity(Activity act) {
        acts.add(act);
    }

    public synchronized void startLoop() {
        isLooping = true;
        thread = new Thread(this, name);
        thread.start();
    }

    public synchronized void stopLoop() throws InterruptedException {
        isLooping = false;
        thread.join();
    }

    public int getloopCount() {
        return loopsLastSecond;
    }

    public String getLoopName() {
        return name;
    }

    @Override
    public void run() {
        loopsLastSecond = 0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / loopsPerSecond;
        double delta = 0;
        int loops = 0;
        while (isLooping) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                loops++;
                delta--;
                for (int i = 0; i < acts.size(); i++) {
                    acts.get(i).run();
                }
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                loopsLastSecond = loops;
                loops = 0;
            }
        }
    }
}
