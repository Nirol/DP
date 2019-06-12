package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Repeated_Subseq {


    public static void repeated_subseq_envelope(String X) {

        int m = X.length();
        int[][] T = new int[m + 1][m + 1];
        repeated_seq_length(X,X,m,m,T);
        System.out.println(new HashSet<>( LCS_TOP_DOWN(X,X,m,m,T)));



    }


    private static void repeated_seq_length(String x, String y, int m, int n, int[][] t) {

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {

                    t[i][j] = t[i - 1][j - 1] + 1;

                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);

                }
            }
        }
    }


    // TOP - DOWN

    private static List<String> LCS_TOP_DOWN(String x, String y, int m, int n, int[][] t) {

        if (m == 0 | n == 0) {
            return new ArrayList<>(Collections.nCopies(1, ""));
        }
        if (x.charAt(m - 1) == y.charAt(n - 1) & m-1 != n-1) {
            List<String> lcs = LCS_TOP_DOWN(x, y, m - 1, n - 1, t);
            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + x.charAt(m - 1));
            }
            return lcs;
        }

        if (t[m][n-1] > t[m-1][n]){
            return LCS_TOP_DOWN(x,y,m,n-1,t);
        }
        if (t[m-1][n] > t[m][n-1]){
            return LCS_TOP_DOWN(x,y,m-1,n,t);
        }

        List<String> top = LCS_TOP_DOWN(x, y, m - 1, n , t);
        List<String> left = LCS_TOP_DOWN(x, y, m , n-1 , t);
        top.addAll(left);
        return top;
    }


}
