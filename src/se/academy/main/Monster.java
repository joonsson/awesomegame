package se.academy.main;

import com.googlecode.lanterna.terminal.Terminal;

public class Monster {
    private char appearance;
    private int x;
    private int y;
    private int speed;
    private int ticker;
    private boolean even;
    private Terminal.Color colour;

    public Monster(char app, int x, int y, int speed, boolean even, Terminal.Color colour) {
        this.appearance = app;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.ticker = 0;
        this.even = even;
        this.colour = colour;
    }

    public void move(int pX, int pY, int ticker) {
        if (ticker % 2 == 0 && even || ticker % 2 != 0 && !even) {
            if (Math.abs(x - pX) >= Math.abs(y - pY)) {
                if (x - pX < 0) {
                    this.x += 2 * speed;
                } else {
                    this.x -= 2 * speed;
                }

            } else {
                if (y - pY < 0) {
                    this.y += speed;
                } else {
                    this.y -= speed;
                }
            }
        }

    }

    public boolean isEven() {
        return even;
    }

    public Terminal.Color getColour() {
        return colour;
    }

    public char getAppearance() {
        return appearance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTicker() {
        return ticker;
    }
    public void updateTicker() {
        ticker++;
    }
}
