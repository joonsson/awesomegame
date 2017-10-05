package se.academy.main;

import java.util.List;

public class Help {
    public void update(Player player, List<Monster> monsterList) {
        //move palyer
        for (Monster monster: monsterList) {
            monster.move(player.getX(), player.getY());
        }
    }
}
