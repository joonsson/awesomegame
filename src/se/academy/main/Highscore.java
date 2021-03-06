package se.academy.main;


import java.io.*;
import java.util.Scanner;

public class Highscore {
    private int[] score;
    private String[] name;

    public Highscore(int score, String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("highscore.txt"));
        String s = "";
        Scanner scanner = new Scanner(s);
        for (int i = 0; i < this.score.length; i++) {
            s = bufferedReader.readLine();

        }
    }

    public Highscore setScore(int ticker, String newName, Highscore highscore) {
        int[] resultScore = new int[score.length + 1];
        for (int i = 0; i < resultScore.length; i++) {
            if (i == score.length) {
                resultScore[i] = ticker;
            } else
                resultScore[i] = score[i];
        }
        String[] resultName = new String[name.length + 1];
        for (int i = 0; i < resultName.length; i++) {
            if (i == name.length) {
                resultName[i] = newName;
            } else
                resultName[i] = name[i];
        }

        int n = score.length;
        int temp = 0;
        String tString = "";

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (resultScore[j - 1] > resultScore[j]) {

                    temp = resultScore[j - 1];
                    tString = resultName[j - 1];

                    resultScore[j - 1] = resultScore[j];
                    resultName[j - 1] = resultName[j];

                    resultScore[j] = temp;
                    resultName[j] = tString;
                }
            }
        }
        for (int i = 0; i < score.length; i++) {
            score[i] = resultScore[i];
        }
        for (int i = 0; i < name.length; i++) {
            name[i] = resultName[i];
        }
        score = resultScore;
        return highscore;

    }


    BufferedReader bufferedReader = new BufferedReader(new FileReader("highscore.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("highscore.txt"));
}






