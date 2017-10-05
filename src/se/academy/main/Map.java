package se.academy.main;

public class Map {
    private char[][] map;


    public Map() {
        map = new char[33][33];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (x == 0 || x == map.length - 1 || y == 0 || y == map.length - 1) {
                    map[x][y] = '\u2588';
                }
            }
        }
    }
    public char[][] getMap() {
        return map;
    }
}
