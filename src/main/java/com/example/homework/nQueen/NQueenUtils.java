package com.example.homework.nQueen;

public class NQueenUtils {

    public static int[] randomPlace(int n) {

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < n; i++) {
            randomSwap(pos);
        }

        return pos;
    }

    public static void randomSwap(int[] pos) {

        int pos1 = random(0, pos.length - 1);
        int pos2 = random(0, pos.length - 1);
        while (pos2 == pos1) {
            pos2 = random(0, pos.length - 1);
        }

        // exchange pos[i], pos[i+1]
        swap(pos, pos1, pos2);
    }

    public static void swap(int[] pos, int pos1, int pos2) {

        int temp = pos[pos1];
        pos[pos1] = pos[pos2];
        pos[pos2] = temp;
    }

    public static int calConflicts(int[] pos) {

        int conflicts = 0;

        for (int i = 0; i < pos.length; i++) {
            for (int j = i + 1; j < pos.length; j++) {
                if ((i - pos[i] == j - pos[j]) || (i + pos[i] == j + pos[j])) {
                    conflicts++;
                }
            }
        }

        return conflicts;
    }

    public static int random(int lowerBound, int upperBound) {

        return (int) (Math.random() * (upperBound - lowerBound + 1));
    }

    public static void print(int[] pos) {

        for (int po : pos) {
            for (int j = 0; j < pos.length; j++) {
                if (j == po) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
