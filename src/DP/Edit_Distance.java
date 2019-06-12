package DP;

public class Edit_Distance {

    public static int edit_distance(String X, String Y) {

        int m = X.length();

        int n = Y.length();
        int basic_edit_distance = recursive_edit_distance(X, m, Y, n);


        // top down non recursive approach:
        int iterative_memoization_edit_distance = iterative_edit_distance(X, m, Y, n);
        System.out.println("Iterative_result:"+iterative_memoization_edit_distance);


        return basic_edit_distance;
    }

    private static int iterative_edit_distance(String x, int m, String y, int n) {

        int[][] memo = new int[m + 1][n + 1];


        // filling the values when one of the strings is empty
        for (int i = 1; i <= m; i++) {
            memo[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            memo[0][j] = j;
        }
        int cost = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {


                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                memo[i][j] = Math.min(memo[i - 1][j] + 1,
                        Math.min(memo[i][j - 1] + 1,
                                memo[i - 1][j - 1] + cost)
                );


            }

        }
        return memo[m][n];


    }

    private static int recursive_edit_distance(String x, int m, String y, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return recursive_edit_distance(x, m - 1, y, n - 1);
        }

        return 1 + Math.min(recursive_edit_distance(x, m - 1, y, n),
                Math.min(recursive_edit_distance(x, m, y, n - 1),
                        recursive_edit_distance(x, m - 1, y, n - 1)
                )
        );


    }

}
