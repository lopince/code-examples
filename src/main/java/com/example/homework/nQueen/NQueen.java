package com.example.homework.nQueen;

import java.util.Arrays;

public class NQueen {


    public static void main(String[] args) {

        nQueen(4);
    }


    private static void nQueen(int n) {

        // pos[i] = j -> [y=i, x=j]
        int[] pos = new int[n];
        Arrays.fill(pos, -1);

        int i = 0;
        while (i >= 0) {
            while (++pos[i] < n && !isLegal(pos, i)) {}

            if (pos[i] < n) {

                // is the last row
                if (i == n - 1) {
                    print(pos, n);
                    --i;

                } else {

                    // go to next row
                    i++;
                    pos[i] = -1;
                }
            } else {

                // backtrace
                i--;
            }
        }
    }

    public static boolean isLegal(int[] pos, int row) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == pos[row] || Math.abs(pos[i] - pos[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[] pos, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == pos[i]) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
