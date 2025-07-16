import java.util.*;

class SubsetSum {
    public static void f(int ind, int[] nums, List<Integer> list, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(list));

        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            
            list.add(nums[i]);
            f(i+1, nums, list, subsets);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        f(0, nums, list, subsets);
        return subsets;
    }
}