package com.example.homework.nQueen;

import java.util.Arrays;
import java.util.Random;

/**
 * Solve N-Queen problem with Simulated Annealing
 */
public class NQueenUsingSA {

    public static final double BEGIN_TEMPERATURE = Math.pow(10, 10);
    public static final double MIN_TEMPERATURE = 1e-100;
    public static final double TEMPERATURE_DROP_RATE = 0.999;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int[] pos = nQueen(10000);

        int conflict = NQueenUtils.calConflicts(pos);
        if (conflict == 0) {
            System.out.println("Solve:");
            NQueenUtils.print(pos);
        } else {
            System.out.println("Unsolve, conflict: " + conflict);
        }

        System.out.println();
        System.out.println("Time consuming: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Time consuming: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
    }


    private static int[] nQueen(int n) {

        int[] pos = NQueenUtils.randomPlace(n);

        int conflict = NQueenUtils.calConflicts(pos);

        double t = BEGIN_TEMPERATURE;
        double minT = MIN_TEMPERATURE;
        double rate = TEMPERATURE_DROP_RATE;

        int iterations = 0;

        while (conflict != 0 && t > minT) {

            // get neighbor
            int[] neighbor = Arrays.copyOf(pos, pos.length);
            NQueenUtils.randomSwap(neighbor);

            // calculate the current conflict
            int cur = NQueenUtils.calConflicts(neighbor);
            int dE = cur - conflict;

            // neighbor is better
            if (dE <= 0) {
                conflict = cur;
                pos = neighbor;
            } else {

                // accept the change base on acceptance probabilities p = e ^ (dE/t)
                if (isAccept(dE, t)) {
                    conflict = cur;
                    pos = neighbor;
                }
            }

            // temperature drop
            t = t * rate;

            System.out.println("Iterate: " + iterations++);
            System.out.println("T: " + t);
            System.out.println("Conflict: " + conflict);
            System.out.println("CurConflict: " + cur + ", dE: " + dE);
            System.out.println("Pos: " + Arrays.toString(pos));
            System.out.println();
        }

        return pos;
    }

    private static boolean isAccept(double dE, double t) {

        // calculate the acceptance probabilities
        if (dE == 0) {
            return true;
        }

        double p = acceptanceProbabilities(dE, t);
        System.out.println("P: " + p);

        return p >= new Random().nextDouble();
    }

    private static double acceptanceProbabilities(double dE, double t) {

        // p = e ^ (dE/t)
        return Math.pow(Math.E, -dE / t);
    }
}
