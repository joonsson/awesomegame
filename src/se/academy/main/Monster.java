package se.academy.main;

public class Monster {
    private char appearance;
    private int x;
    private int y;
    private int speed;

    public Monster(char app, int x, int y, int speed) {
        this.appearance = app;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void move(int pX, int pY) {
        if (Math.abs(x - pX) >= Math.abs(y - pY)) {
            if (x - pX < 0) {
                this.x += speed;
            } else {
                this.x -= speed;
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
}
