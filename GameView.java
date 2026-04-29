

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;

        setTitle("Waterful Ring Toss");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Basic blank panel for now
        add(new GamePanel());

        setVisible(true);
    }

    // --- Rendering Panel ---
    private class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // stub: draw background, rings, pegs, timer, overlays
            g.drawString("Waterful Ring Toss (MVC Shell)", 20, 20);
        }
    }

    public void refresh() {
        repaint();
    }
}
