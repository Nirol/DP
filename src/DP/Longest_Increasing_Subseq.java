package DP;

import org.jetbrains.annotations.NotNull;


import java.time.Instant;
import java.util.Arrays;

import static java.lang.Integer.*;



public class Longest_Increasing_Subseq {


    public static void substring(@NotNull int[] nums) {

        /*
        Recursive solution witho memoization, so very bad run time.

         */
        int n = nums.length;
        long startTime = System.currentTimeMillis();
        Instant start_rec = Instant.now();
        int recursive_ans= recursive_sol(nums,0,n, MIN_VALUE);


        System.out.println("rec ans: "+recursive_ans);



        long stopTime = System.currentTimeMillis();
        long elapsedTime_rec = stopTime - startTime;
        Instant end_rec = Instant.now();


                /*
        In order to use memoization we will use bottom-up iterative approach

         */
         startTime = System.currentTimeMillis();

        int iterative_memo_ans= iterative_memo_sol(nums);
         stopTime = System.currentTimeMillis();
        long elapsedTime_iter = stopTime - startTime;

        System.out.println("Compare method times:");
        System.out.println("Recurssion Method:"+elapsedTime_rec);
        System.out.println("Recurssion Method:"+elapsedTime_iter);

    }

    private static int iterative_memo_sol(int[] nums) {

        int[] lookup = new int[nums.length];

        lookup[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if ( nums[j] < nums[i] && lookup[j] > lookup[i]){

                    lookup[i]=lookup[j];
                }
            }
            lookup[i]=lookup[i]+1;

        }
         return Arrays.stream(lookup).max().getAsInt();
    }

    private static int recursive_sol(int[] nums, int i, int n, int minValue) {
        if (i == n){
            return 0;
        }
        int exclude,include = -1;
        if (nums[i] > minValue){
            include = 1 + recursive_sol(nums,i+1,n,nums[i]);
        }
        exclude = recursive_sol(nums,i+1,n,minValue);

        return  Math.max(include,exclude);
    }






}
