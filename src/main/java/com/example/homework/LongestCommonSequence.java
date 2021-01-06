package com.example.homework;

import java.util.Arrays;

public class LongestCommonSequence {

    public static void main(String[] args) {

        // LongestCommonSequence for x & y: {34678}
        char[] x = "abcbcba".toCharArray();
        char[] y = "abcba".toCharArray();

        int[][] c = LCS(x, y);
        System.out.println("c[][]: ");
        Arrays.stream(c)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("LongestCommonSequence len: " + c[c.length - 1][c[0].length - 1]);
        System.out.println();

        System.out.println("LongestCommonSequence: " + getLongestCommonSequence(c, x));
        System.out.println();

        System.out.println("LCS2: " + LCS2(x, y));
    }

    /**
     * LSC(i, j):
     * <p>
     * 0                             i=0, j=0
     * LCS(i-1, j-1) + 1             i, j > 0; x[i] == y[j]
     * max(LCS(i, j-1), LSC(i-1, j)) i, j > 0; x[i] != y[j]
     */
    public static int[][] LCS(char[] yChars, char[] xChars) {

        int yLen = yChars.length;
        int xLen = xChars.length;

        // c[i][j] 标识序列X和Y的最长公共子序列长度
        int[][] c = new int[yLen + 1][xLen + 1];

        for (int i = 1; i <= yLen; i++) {
            for (int j = 1; j <= xLen; j++) {

                if (yChars[i - 1] == xChars[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }

        return c;
    }

    public static String getLongestCommonSequence(int[][] c, char[] x) {

        // 最长公共子序长度
        int sequenceLen = c[c.length - 1][c[0].length - 1];

        // 公共子序从1开始递增
        int index = 1;
        int i = 1;
        StringBuilder ans = new StringBuilder();
        while (index <= sequenceLen) {

            for (; i < c.length; i++) {

                boolean next = false;
                for (int j = 0; j < c[0].length; j++) {

                    // 公共子序第一次出现递增
                    if (c[i][j] == index) {

                        // x[i-1]即为当前子序的最后一个字符(x的下标从0开始)
                        ans.append(x[i - 1]);
                        next = true;
                        break;
                    }
                }

                if (next) {
                    break;
                }
            }

            index++;
        }

        return ans.toString();
    }

    public static String LCS2(char[] yChars, char[] xChars) {

        int yLen = yChars.length;
        int xLen = xChars.length;

        int index = 1;
        StringBuilder ans = new StringBuilder();

        // 保存上一行信息
        int[] pre_c = new int[xLen + 1];

        // 保存当前行信息
        int[] c = new int[xLen + 1];

        for (int y = 1; y <= yLen; y++) {
            for (int x = 1; x <= xLen; x++) {

                if (yChars[y - 1] == xChars[x - 1]) {

                    // LCS(i-1, j-1) + 1
                    c[x] = pre_c[x - 1] + 1;

                    // 在计算的过程中，拼凑公共子序列
                    if (index == c[x]) {
                        ans.append(xChars[x - 1]);
                        index++;
                    }

                } else {

                    // max(LCS(i, j-1), LSC(i-1, j))
                    c[x] = Math.max(c[x - 1], pre_c[x]);
                }
            }

            // 迭代保存当前行
            pre_c = c;
            System.out.println(Arrays.toString(c));
        }


        return ans.toString();
    }


}
