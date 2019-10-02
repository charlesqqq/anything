package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), new int[]{1, 2, 3});
        // 123 132 213 231 312 321
        System.out.println(list);
    }

    private static void backtrack(List<List<Integer>> list, ArrayList<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length)
            list.add(new ArrayList<>(tmp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i]))
                    continue;

                tmp.add(nums[i]);
                backtrack(list, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
