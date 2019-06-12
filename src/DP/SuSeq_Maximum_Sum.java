package DP;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;

public class SuSeq_Maximum_Sum {

    public static void substring_max_sum(@NotNull int[] nums) {

        /*
        Recursive solution witho memoization, so very bad run time.

         */
        int n = nums.length;
        long startTime = System.currentTimeMillis();
        Instant start_rec = Instant.now();
        int recursive_ans = recursive_sol(nums, 0, 0, n, MIN_VALUE);
        long stopTime = System.currentTimeMillis();
        long elapsedTime_rec = stopTime - startTime;

        System.out.println("rec ans: " + recursive_ans);


                /*
        In order to use memoization we will use bottom-up iterative approach

         */
        startTime = System.currentTimeMillis();

        int iterative_memo_ans = iterative_sol(nums);
        System.out.println("iter ans: " + iterative_memo_ans);
        stopTime = System.currentTimeMillis();
        long elapsedTime_iter = stopTime - startTime;

        System.out.println("Compare method times:");
        System.out.println("Recurssion Method:" + elapsedTime_rec);
        System.out.println("Iter Method:" + elapsedTime_iter);




        /*
        Saving  the weights used

         */

         iterative_saved_sol(nums);


    }

    private static void iterative_saved_sol(int[] nums) {

        int n = nums.length;
        ArrayList<Integer>[] saved_sums = new ArrayList[n];
        // initializing
        for (int i = 0; i < n; i++) {
            saved_sums[i] = new ArrayList<Integer>();
        }
        saved_sums[0].add(nums[0]);

        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (sums[j] > sums[i] && nums[i] > nums[j]
                ) {
                    sums[i] = sums[j];
                    saved_sums[i].add(nums[j]);
                }

            }
            saved_sums[i].add(nums[i]);
            sums[i] = sums[i] + nums[i];
        }

        for (ArrayList arr:saved_sums
             ) {
            System.out.println(arr.toString());

        }


    }

    private static int iterative_sol(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (sums[j] > sums[i] && nums[i] > nums[j]
                ) {
                    sums[i] = sums[j];
                }

            }
            sums[i] = sums[i] + nums[i];
        }


        return Arrays.stream(sums).max().getAsInt();


    }


    private static int recursive_sol(int[] nums, int sum, int i, int n, int minValue) {
        if (i == n) {
            return 0;
        }
        int exclude, include = -1;
        if (nums[i] > minValue) {
            include = nums[i] + recursive_sol(nums, sum, i + 1, n, nums[i]);
        }
        exclude = recursive_sol(nums, sum, i + 1, n, minValue);

        return Math.max(include, exclude);
    }
}
