package se.academy.main;

public class Monster {
    private char appearance;
    private int x;
    private int y;
    private int speed;
    private int ticker;

    public Monster(char app, int x, int y, int speed) {
        this.appearance = app;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.ticker = 0;
    }

    public void move(int pX, int pY) {
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
                this.y -=speed;
            }
        }

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
