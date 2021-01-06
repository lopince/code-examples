package com.example.homework.nQueen;

import java.util.Arrays;

public class NQueenUsingLocalSearch {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int[] pos = nQueen(1000);
//        print(pos);
        System.out.println(Arrays.toString(pos));

        System.out.println("Time consuming: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static int[] nQueen(int n) {

        // initialize random nQueen position
        int[] pos = NQueenUtils.randomPlace(n);

        // calculate nQueen conflict
        int conflicts = NQueenUtils.calConflicts(pos);
        int count = 0;
        int i = 0;
        while (conflicts != 0) {

            // get neighbors by swapping the positions of any two queens
            int[] neighbor;
            if (count > 100) {
                neighbor = NQueenUtils.randomPlace(n);
                count = 0;
            } else {
                neighbor = Arrays.copyOf(pos, pos.length);
                NQueenUtils.randomSwap(neighbor);
            }

            // if conflicts being decrease, accept the swap
            int c = NQueenUtils.calConflicts(neighbor);
            if (c < conflicts) {
                conflicts = c;
                pos = neighbor;
                count = 0;
            } else {

                // if conflicts dose not decrease
                count++;
            }

            System.out.println(i++);
            System.out.println("cur conflicts: " + conflicts);
            System.out.println("cur pos: " + Arrays.toString(pos));
            System.out.println("cur neighbor: " + Arrays.toString(neighbor));
            System.out.println("cur count: " + count);
            System.out.println();
        }

        return pos;
    }





}
