package se.academy.main;

public class Player {
    private int x;
    private int y;
    private int lives;
    private char appearance;

    public Player() {
        x = 100;
        y = 100;
        lives = 1;
        appearance = 'O';
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
}
