package se.academy.main;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.Random;

public class Shade {
    private char appearance;
    private int x;
    private int y;
    private int tX = - 20;
    private int tY = - 20;
    private int speed;
    private int ticker;
    private boolean even;
    private Colour colour;

    public Shade(char app, int x, int y, int speed, boolean even, Colour colour) {
        this.appearance = app;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.ticker = 0;
        this.even = even;
        this.colour = colour;
    }

    public void move(int pX, int pY, int ticker) {
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
    private void teleportA() {
        x = tX;
        y = tY;
    }
    private void teleportB(int pX, int pY) {
        Random rand = new Random();
        int rX, rY;
        while (true) {
            rX = rand.nextInt(61) + 1;
            rY = rand.nextInt(27) + 1;
            if (Math.abs(rX-pX) < 4 && Math.abs(rY-pY) < 4) {
                break;
            }
        }
        x = rX;
        y = rY;
    }
    public boolean isEven() {
        return even;
    }

    public Colour getColour() {
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

    public void updateTicker(Player player) {
        ticker++;
        if (ticker%10 == 0) {
            teleportA();
        }
        if (ticker%12 == 0) {
            teleportB(player.getX(), player.getY());
        }
    }
}
