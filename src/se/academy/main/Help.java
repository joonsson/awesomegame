package se.academy.main;

import java.util.List;

public class Help {
    public void update(Player player, List<Monster> monsterList, List<Shade> shadeList) {
        for (Monster monster: monsterList) {
            monster.move(player.getX(), player.getY(), player.getTicker());
        }
        for (Shade shade: shadeList) {
            shade.move(player.getX(), player.getY(), player.getTicker());
        }
    }
    public boolean checkMapCollision(Player player, char[][] mapArray) {
        return false;
    }
    public boolean checkMonsterCollision(Player player, List<Monster> monsterList, List<Shade> shadeList) {
        int pX = player.getX();
        int pY = player.getY();
        for (Monster monster: monsterList) {
            int mX = monster.getX();
            int mY = monster.getY();
            if (pX == mX && pY == mY) {
                return true;
            }
        }
        for (Shade shade: shadeList) {
            int mX = shade.getX();
            int mY = shade.getY();
            if (pX == mX && pY == mY) {
                return true;
            }
        }
        return false;
    }
    public void updateTickers(Player player, List<Monster> monsterList, List<Shade> shadeList) {
        player.updateTicker();
        for (Monster monster: monsterList) {
            monster.updateTicker();
        }
        for (Shade shade: shadeList) {
            shade.updateTicker(player);
        }
    }
}
