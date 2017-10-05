package se.academy.main;

import java.util.List;

public class Help {
    public void update(Player player, List<Monster> monsterList) {
        for (Monster monster: monsterList) {
            monster.move(player.getX(), player.getY());
        }
    }
    public boolean checkMapCollision(Player player, char[][] mapArray) {
        return false;
    }
    public boolean checkMonsterCollision(Player player, List<Monster> monsterList) {
        int pX = player.getX();
        int pY = player.getY();
        for (Monster monster: monsterList) {
            int mX = monster.getX();
            int mY = monster.getY();
            if (pX == mX && pY == mY) {
                return true;
            }
        }
        return false;
    }
}
