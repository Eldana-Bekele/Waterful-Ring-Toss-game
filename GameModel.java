

import java.util.List;
import java.util.ArrayList;

public class GameModel {

    // --- Game State ---
    private int roundNumber = 1;
    private int timerSeconds;
    private boolean isWin;
    private boolean isLoss;

    private List<Ring> rings = new ArrayList<>();
    private List<Peg> pegs = new ArrayList<>();

    // --- Entities ---
    public static class Ring {
        public enum State { FREE, SCORED }

        public int x, y;
        public double vx, vy;
        public String color;
        public State state = State.FREE;
    }

    public static class Peg {
        public int x, y;
        public String color;
        public boolean occupied = false;
    }

    // --- Initialization ---
    public void startRound(int round) {
        this.roundNumber = round;
        this.isWin = false;
        this.isLoss = false;
        initRings();
        initPegs();
        resetTimer();
    }

    private void initRings() {
        rings.clear();
        // stub: populate rings based on difficulty
    }

    private void initPegs() {
        pegs.clear();
        // stub: populate pegs based on difficulty
    }

    private void resetTimer() {
        timerSeconds = 30; // placeholder
    }

    // --- Physics Updates ---
    public void updatePhysics() {
        // stub: gravity, movement, collisions, settlement
    }

    public void applyBoost() {
        // stub: upward impulse
    }

    public void applyLeft() {
        // stub: left impulse
    }

    public void applyRight() {
        // stub: right impulse
    }

    // --- Game State ---
    public void tickTimer() {
        timerSeconds--;
        if (timerSeconds <= 0) {
            isLoss = true;
        }
    }

    public int getRoundNumber() {
    return roundNumber;
}


    public boolean isWin() { return isWin; }
    public boolean isLoss() { return isLoss; }
    public int getTimer() { return timerSeconds; }
    public List<Ring> getRings() { return rings; }
    public List<Peg> getPegs() { return pegs; }

    public void checkWinCondition() {
        // stub: all rings scored
    }
}
