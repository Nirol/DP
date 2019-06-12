package DP;

public class Matrix_Paths {



    public static int findMinCost_rec(int[][] cost, int m, int n) {

        // base case
        if (n == 0 || m == 0) {
            return Integer.MAX_VALUE;
        }

        // if we're at first cell (0, 0)
        if (m == 1 && n == 1) {
            return cost[0][0];
        }
        // include cost of the current cell in path and recur to find minimum of
        // the path from adjacent left cell and adjacent top cell.
        return Integer.min(findMinCost_rec(cost, m - 1, n), findMinCost_rec(cost, m, n - 1))
                + cost[m - 1][n - 1];
    }

    // iteration bottom up

    public static int findMinCost__iter(int[][] cost) {
        int m= cost.length;
        int n = cost[0].length;

        int[][] lookup = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lookup[i][j]=cost[i][j];

                if (i==0 & j>0){
                    lookup[i][j]+=lookup[i][j-1];
                }
                else if( i>0 & j==0){
                    lookup[i][j]+=lookup[i-1][j];
                }
                else if( i> 0 & j>0) {
                    lookup[i][j]+=Math.min( lookup[i-1][j] ,lookup[i][j-1] );

                }
            }
        }
        return lookup[m-1][n-1];
    }

}
