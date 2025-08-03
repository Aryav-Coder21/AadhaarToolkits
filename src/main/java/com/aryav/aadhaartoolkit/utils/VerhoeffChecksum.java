package com.aryav.aadhaartoolkit.utils;

public class VerhoeffChecksum {

    private static final int[][] d = {
        {0,1,2,3,4,5,6,7,8,9},
        {1,2,3,4,0,6,7,8,9,5},
        {2,3,4,0,1,7,8,9,5,6},
        {3,4,0,1,2,8,9,5,6,7},
        {4,0,1,2,3,9,5,6,7,8},
        {5,9,8,7,6,0,4,3,2,1},
        {6,5,9,8,7,1,0,4,3,2},
        {7,6,5,9,8,2,1,0,4,3},
        {8,7,6,5,9,3,2,1,0,4},
        {9,8,7,6,5,4,3,2,1,0}
    };

    private static final int[][] p = {
        {0,1,2,3,4,5,6,7,8,9},
        {1,5,9,8,4,2,7,0,6,3},
        {5,8,0,3,7,9,6,1,2,4},
        {8,9,1,6,0,4,3,5,7,2},
        {9,4,5,3,1,2,6,8,0,7},
        {4,3,2,6,8,7,1,9,5,0},
        {3,7,6,1,9,0,8,4,2,5},
        {7,0,4,2,6,5,9,3,1,8}
    };

    private static final int[] inv = {0,4,3,2,1,5,6,7,8,9};

    public static boolean validateVerhoeff(String num) {
        if (num == null || !num.matches("^[2-9]{1}[0-9]{11}$")) return false;
        int c = 0;
        int[] myArray = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            myArray[i] = Character.getNumericValue(num.charAt(num.length() - (i + 1)));
        }
        for (int i = 0; i < myArray.length; i++) {
            c = d[c][p[i % 8][myArray[i]]];
        }
        return c == 0;
    }
}