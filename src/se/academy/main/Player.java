package se.academy.main;

import com.googlecode.lanterna.terminal.Terminal;

public class Player {
    private int x;
    private int y;
    private int lives;
    private char appearance;
    private int ticker;
    private Colour colour;

    public Player() {
        x = 30;
        y = 15;
        lives = 1;
        appearance = '\u263A';
        ticker = -1;
        colour = new Colour(250, 0, 150);
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

    public Colour getColour() {
        return colour;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
