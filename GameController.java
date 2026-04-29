import javax.swing.*;
import java.awt.event.*;

public class GameController {

    private GameModel model;
    private GameView view;
    private Timer gameLoop;

    public GameController() {
        model = new GameModel();
        view = new GameView(model);

        model.startRound(1);

        setupInput();
        setupGameLoop();
    }

    private void setupInput() {
        // Key bindings for Boost, Left, Right, Restart
        JComponent root = (JComponent) view.getContentPane();

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("SPACE"), "boost");
        root.getActionMap().put("boost", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                model.applyBoost();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("LEFT"), "left");
        root.getActionMap().put("left", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                model.applyLeft();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("RIGHT"), "right");
        root.getActionMap().put("right", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                model.applyRight();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("R"), "restart");
        root.getActionMap().put("restart", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                if (model.isLoss()) {
                    model.startRound(model.getRoundNumber());

                }
            }
        });
    }

    private void setupGameLoop() {
        gameLoop = new Timer(16, e -> {
            model.updatePhysics();
            model.checkWinCondition();
            view.refresh();
        });
        gameLoop.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameController::new);
    }
}
