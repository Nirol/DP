package DP;

import org.jetbrains.annotations.NotNull;

public class Substring {

    public static String substring(@NotNull String X, @NotNull String Y) {
        int[][] lookup = new int[X.length()+1][Y.length()+1];
        String ans = backTracking_substrings(lookup,X,Y);
        return ans;
    }

    @NotNull
    private static String backTracking_substrings(int[][] lookup, @NotNull String X, String Y) {
        int maxLength=0;
        int end_idx=-1;

        for (int i = 1; i <= X.length(); i++) {

            for (int j = 1; j <= Y.length(); j++) {

                if (X.charAt(i-1) == Y.charAt(j-1)){
                    lookup[i][j]=lookup[i-1][j-1] + 1;
                    if (lookup[i][j] > maxLength){
                        maxLength=lookup[i][j];
                        end_idx=i;
                    }

                }

            } // i for loop

        } //j for loop

        return X.substring(end_idx-maxLength, end_idx);

    }
}
