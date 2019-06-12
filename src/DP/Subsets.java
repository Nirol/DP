package DP;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

This DP problem is finding all subset of a number set

 */
public class Subsets {




    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        Arrays.sort(nums);
        backTracking_subsets(mainList,new ArrayList<>(),nums,0);
        return mainList;
    }

    @Contract("_, _, _, _ -> param1")
    public static List<List<Integer>> backTracking_subsets(@NotNull List<List<Integer>> mainList,
                                                           List<Integer> tempList, @NotNull int[] nums, int idx) {
        // no stop condition on the subset problem
        mainList.add(new ArrayList<>(tempList));
        for (int i = idx; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking_subsets(mainList, tempList, nums, idx+1);
            tempList.remove(tempList.size()-1);
        }
        return mainList;
    }

}
