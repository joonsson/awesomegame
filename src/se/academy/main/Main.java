package se.academy.main;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF16"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        boolean ingame = true;
        while (ingame) {
            int scoreX = 70;
            int scoreY = 28;
            Map map = new Map();
            char[][] mapArray = map.getMap();
            Help helper = new Help();
            Player player = new Player();
            List<Monster> monsterList = new ArrayList<>();
            List<Shade> shadeList = new ArrayList<>();
            Colour purple = new Colour(50, 0, 50);
            Colour green = new Colour(0, 255, 0);
            Colour blue = new Colour(0, 0, 255);
            Colour red = new Colour(255, 0, 0);
            Monster monsterOne = new Monster('X', 4, 5, 1, false, green);
            Monster monsterTwo = new Monster('X', 4, 20, 1, true, green);
            Monster monsterThree = new Monster('X', 40, 6, 2, true, red);
            Monster monsterFour = new Monster('X', 40, 20, 2, false, red);
            Shade shadeOne = new Shade('O', 4, 15, 1, true, purple);
            shadeList.add(shadeOne);
            monsterList.add(monsterOne);
            monsterList.add(monsterTwo);
            boolean alive = true;
            boolean sleep = false;
            terminal.moveCursor(30, 15);
            terminal.putCharacter('O');

            while (alive) {
                if (sleep) {
                    Thread.sleep(2000);
                    sleep = false;
                }
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
                        if (mapArray[pX][pY + 1] == '\u0000') {
                            player.move(0, 1);
                        }
                        break;
                    case ArrowLeft:
                        if (mapArray[pX - 1][pY] == '\u0000' && mapArray[pX - 2][pY] == '\u0000') {
                            player.move(-2, 0);
                        }
                        break;
                    case ArrowRight:
                        if (mapArray[pX + 1][pY] == '\u0000' && mapArray[pX + 2][pY] == '\u0000') {
                            player.move(2, 0);
                        }
                        break;
                    case ArrowUp:
                        if (mapArray[pX][pY - 1] == '\u0000') {
                            player.move(0, -1);
                        }
                }
                terminal.clearScreen();
                helper.update(player, monsterList, shadeList);
                helper.updateTickers(player, monsterList, shadeList);
                if (player.getTicker() == 100) {
                    player.setX(30);
                    player.setY(15);
                    monsterList.add(monsterThree);
                    monsterList.add(monsterFour);
                    map.secondMap();
                    for (Monster monster : monsterList) {
                        monster.setX(monster.getStartX());
                        monster.setY(monster.getStartY());
                    }
                    for (Shade shade : shadeList) {
                        shade.setX(shade.getStartX());
                        shade.setY(shade.getStartY());
                    }
                    sleep = true;
                }
                terminal.applyForegroundColor(map.getColour());
                for (int i = 0; i < mapArray.length; i++) {
                    for (int j = 0; j < mapArray.length - 33; j++) {
                        if (mapArray[i][j] != '\u0000') {
                            terminal.moveCursor(i, j);
                            terminal.putCharacter(mapArray[i][j]);
                        }
                    }
                }
                terminal.applyForegroundColor(player.getColour().getR(), player.getColour().getG(), player.getColour().getB());
                terminal.moveCursor(player.getX(), player.getY());
                terminal.putCharacter(player.getAppearance());
                for (Monster monster : monsterList) {
                    terminal.applyForegroundColor(monster.getColour().getR(), monster.getColour().getG(), monster.getColour().getB());
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
                    terminal.moveCursor(scoreX + i - 5, scoreY - 1);
                    terminal.putCharacter(score.charAt(i));
                }
                for (int i = 0; i < steps.length(); i++) {
                    terminal.moveCursor(scoreX + i, scoreY);
                    terminal.putCharacter(steps.charAt(i));
                }
                boolean monsterCollision = helper.checkMonsterCollision(player, monsterList, shadeList);
                if (monsterCollision) alive = false;
            }
            Thread.sleep(2000);
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            } while (key == null);
            System.out.println(key);
            int pX = player.getX();
            int pY = player.getY();

            switch (key.getKind()) {
                case Escape:
                    ingame = false;
                    break;
            }
        }
    }
}
