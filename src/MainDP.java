import DP.Shortest_Common_SuperSeq;

public class MainDP {

    public static void main(String[] args) {

        /*
        Invoking Subset DP

         */

        // int[] nums = {8,7,6,5,4,3,2,1};
        // List<List<Integer>> ans =  App.subsets(nums);
        // Iterator<List<Integer>> ansIterator = ans.iterator();
        // while (ansIterator.hasNext()) {
        // 	System.out.println(ansIterator.next());
        // }


        /*
        Invoking SubSeq DP
         */
//        String X = "ABCBDAB", Y = "BDCABA";
//        DP.Subsequence.subseq_envelope(X, Y);

/*

Invoking Repeating SubSeq DP

 */
      //  String Z="ABBACFFCGGGTT";
        //DP.Repeated_Subseq.repeated_subseq_envelope(Z);



            /*
            Invoking DP.Substring DP
             */
//        String X = "hhhgglafgkkk";
//        String Y = "aaagggglaf6gbbb";
//        System.out.println(DP.Substring.substring(X, Y));

     /*
     DP.Longest_Increasing_Subseq
      */

//        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
//        DP.Longest_Increasing_Subseq.substring(A);

     /*
     DP.SuSeq_Maximum_Sum
      */

//
//        int arr[] = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
//        DP.SuSeq_Maximum_Sum.substring_max_sum(arr);



        /*

        Edit _ Distance

         */
//        String X="kitten";
//        String Y="sitting";
//
//        System.out.println( DP.Edit_Distance.edit_distance(X,Y));



        /*
        min cost matrix path
         */

//        int[][] cost =
//                {
//                        { 4, 7, 8, 6, 4 },
//                        { 6, 7, 3, 9, 2 },
//                        { 3, 8, 1, 2, 4 },
//                        { 7, 1, 7, 3, 7 },
//                        { 2, 9, 8, 9, 3 }
//                };
//
//        System.out.print("The minimum cost is "
//                + DP.Matrix_Paths.findMinCost_rec(cost, cost.length, cost[0].length));
//        System.out.println();
//        System.out.print("The minimum cost is "
//                + DP.Matrix_Paths.findMinCost__iter(cost));
//


        /*
        Shortest common subseq

         */

        String X = "ABCBDAB", Y = "BDCABA";

        Shortest_Common_SuperSeq.shortest_common_superseq_envelope(X,Y);






    }




    }

