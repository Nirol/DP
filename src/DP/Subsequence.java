package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;


public class Subsequence {




    public static void subseq_envelope(String X, String Y) {

        int m = X.length();
        int n = Y.length();


        // T[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]

        int[][] T = new int[m + 1][n + 1];

        // fill lookup table
        LCSLength(X, Y, m, n, T);

        // find longest common sequence
        System.out.print(new HashSet<>(Subsequence.LCS(X, Y, m, n, T)));


    }

    private static List<String> LCS(String x, String y, int m, int n, int[][] t) {

        if (m == 0 | n == 0) {
            return new ArrayList<>(Collections.nCopies(1, ""));
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            List<String> lcs = LCS(x, y, m - 1, n - 1, t);
            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + x.charAt(m - 1));
            }
            return lcs;
        }

        if (t[m][n-1] > t[m-1][n]){
            return LCS(x,y,m,n-1,t);
        }
        if (t[m-1][n] > t[m][n-1]){
            return LCS(x,y,m-1,n,t);
        }

        List<String> top = LCS(x, y, m - 1, n , t);
        List<String> left = LCS(x, y, m , n-1 , t);
        top.addAll(left);
        return top;
    }

    private static void LCSLength(String x, String y, int m, int n, int[][] t) {

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (x.charAt(i-1) == y.charAt(j-1)) {

                    t[i][j] = t[i - 1][j - 1] + 1;

                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);

                }


            }
        }


    }
}
