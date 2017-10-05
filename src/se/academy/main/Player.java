package se.academy.main;

import com.googlecode.lanterna.terminal.Terminal;

public class Player {
    private int x;
    private int y;
    private int lives;
    private char appearance;
    private int ticker;
    private Terminal.Color colour;

    public Player() {
        x = 16;
        y = 16;
        lives = 1;
        appearance = '\u263A';
        ticker = 0;
        colour = Terminal.Color.MAGENTA;
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLives() {
        return lives;
    }

    public char getAppearance() {
        return appearance;
    }

    public int getTicker() {
        return ticker;
    }
    public void updateTicker() {
        ticker++;
    }

    public Terminal.Color getColour() {
        return colour;
    }
}
