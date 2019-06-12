package DP;

public class Shortest_Common_SuperSeq {




    public static void shortest_common_superseq_envelope(String X, String Y){



        int m = X.length(), n = Y.length();

        // lookup table stores solution to already computed sub-problems
        // T[i][j] stores the length of SCS of substring X[0..i-1], Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];

        fillLookup(X,Y,m,n,T);
        System.out.println(recursvie_top_down_sol(X,Y,m,n,T));


    }

    private static String recursvie_top_down_sol(String x, String y, int m, int n, int[][] t) {

        if (n <= 0){

            return x.substring(0 ,m);
        }

        if ( m <= 0 ){
            return y.substring(0, n);
        }
        if (x.charAt(m-1)== y.charAt(n-1)){

            return  recursvie_top_down_sol(x,y,m-1,n-1,t) + x.charAt(m-1);
        }

        if (t[m-1][n] < t[m][n-1]){

            return recursvie_top_down_sol(x,y,m-1,n,t) + x.charAt(m-1);
        }

        return recursvie_top_down_sol(x,y,m,n-1,t)+ x.charAt(n-1);

    }


    /*
    bottom up filling lookup shortest subseq.
     */
    private static void fillLookup(String X, String Y, int m, int n, int[][] T) {

        for (int i = 0; i <= m; i++) {
            T[i][0] = i;
        }

        // initialize first row of the lookup table
        for (int j = 0; j <= n; j++) {
            T[0][j] = j;
        }

        for (int i = 1; i <=m ; i++) {
            for (int j = 1 ; j <= n ; j++) {


                if (X.charAt(i-1) == Y.charAt(j-1)){
                    T[i][j]= T[i-1][j-1]+1;
                }
                else{
                    T[i][j]=Math.min(T[i-1][j]+1,T[i][j-1]+1);
                }

            }

        }






    }


}
