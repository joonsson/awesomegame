package se.academy.main;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        int scoreX = 70;
        int scoreY = 28;
        Map map =  new Map();
        char[][] mapArray = map.getMap();
        Help helper = new Help();
        Player player = new Player();
        List<Monster> monsterList = new ArrayList<>();
        List<Shade> shadeList = new ArrayList<>();
        Colour purple = new Colour(50, 0, 50);
        Monster monsterOne = new Monster('X', 10, 10, 1, false, Terminal.Color.GREEN);
        Monster monsterTwo = new Monster('X', 20, 20, 1, true, Terminal.Color.RED);
        Shade shadeOne = new Shade('\u1F47', 15, 25, 1, true, purple);
        shadeList.add(shadeOne);
        monsterList.add(monsterOne);
        monsterList.add(monsterTwo);
        boolean ingame = true;
        terminal.moveCursor(20, 20);
        terminal.putCharacter('O');

        while (ingame) {
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            } while (key == null);
            System.out.println(key);
            int pX = player.getX();
            int pY = player.getY();

            switch (key.getKind()) {
                case ArrowDown:
                    if (mapArray[pX][pY+1] == '\u0000') {
                        player.move(0, 1);
                    }
                    break;
                case ArrowLeft:
                    if (mapArray[pX-1][pY] == '\u0000' && mapArray[pX-2][pY] == '\u0000') {
                        player.move(-2, 0);
                    }
                    break;
                case ArrowRight:
                    if (mapArray[pX+1][pY] == '\u0000' && mapArray[pX+2][pY] == '\u0000') {
                        player.move(2, 0);
                    }
                    break;
                case ArrowUp:
                    if (mapArray[pX][pY-1] == '\u0000') {
                        player.move(0, -1);
                    }
            }
            terminal.clearScreen();
            helper.update(player, monsterList, shadeList);
            helper.updateTickers(player, monsterList, shadeList);
            if (player.getTicker() > 99) map.secondMap();
            terminal.applyForegroundColor(map.getColour());
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray.length - 33; j++) {
                    if (mapArray[i][j] != '\u0000') {
                        terminal.moveCursor(i, j);
                        terminal.putCharacter(mapArray[i][j]);
                    }
                }
            }
            terminal.applyForegroundColor(player.getColour());
            terminal.moveCursor(player.getX(), player.getY());
            terminal.putCharacter(player.getAppearance());
            for (Monster monster : monsterList) {
                terminal.applyForegroundColor(monster.getColour());
                terminal.moveCursor(monster.getX(), monster.getY());
                terminal.putCharacter(monster.getAppearance());
            }
            for (Shade shade : shadeList) {
                terminal.applyForegroundColor(shade.getColour().getR(), shade.getColour().getG(), shade.getColour().getB());
                terminal.moveCursor(shade.getX(), shade.getY());
                terminal.putCharacter(shade.getAppearance());
            }
            terminal.applyForegroundColor(Terminal.Color.WHITE);
            String score = "Score:";
            String steps = "" + player.getTicker();
            for (int i = 0; i < score.length(); i++) {
                terminal.moveCursor(scoreX + i - 5,scoreY - 1);
                terminal.putCharacter(score.charAt(i));
            }
            for (int i = 0; i < steps.length(); i++) {
                terminal.moveCursor(scoreX + i,scoreY);
                terminal.putCharacter(steps.charAt(i));
            }
            boolean monsterCollision = helper.checkMonsterCollision(player, monsterList, shadeList);
            if (monsterCollision) ingame = false;
        }
        System.out.println("Game over");
    }
}
