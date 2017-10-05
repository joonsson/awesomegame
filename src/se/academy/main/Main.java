package se.academy.main;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        Map map =  new Map();
        Help helper = new Help();
        Player player = new Player();
        List<Monster> monsterList = new ArrayList<>();
        Monster monsterOne = new Monster('X', 10, 10, 1);
        monsterList.add(monsterOne);
        boolean ingame = true;
        while (ingame) {
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            } while (key == null);
            System.out.println(key);
            switch (key.getKind()) {
                case ArrowDown:
                    player.move(0, 1);
                    break;
                case ArrowLeft:
                    player.move(-2, 0);
                    break;
                case ArrowRight:
                    player.move(2, 0);
                    break;
                case ArrowUp:
                    player.move(0, -1);
            }
            terminal.clearScreen();
            helper.update(player, monsterList);
            char[][] mapArray = map.getMap();
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray.length - 30; j++) {
                    if (mapArray[i][j] != '\u0000') {
                        terminal.moveCursor(i, j);
                        terminal.putCharacter(mapArray[i][j]);
                    }
                }
            }
            terminal.moveCursor(player.getX(), player.getY());
            terminal.putCharacter(player.getAppearance());
            for (Monster monster : monsterList) {
                terminal.moveCursor(monster.getX(), monster.getY());
                terminal.putCharacter(monster.getAppearance());
            }
            helper.updateTickers(player, monsterList);
            boolean monsterCollision = helper.checkMonsterCollision(player, monsterList);
            if (monsterCollision) ingame = false;
        }
        System.out.println("Game over");
    }
}
