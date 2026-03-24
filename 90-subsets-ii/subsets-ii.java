class Solution {

public List<List<Integer>> subsetsWithDup(int[] nums) {

    List<List<Integer>> ans = new ArrayList<>();

    // Step 1: Sort array to group duplicates
    Arrays.sort(nums);

    // Start backtracking
    backtrack(nums, ans, new ArrayList<>(), 0);

    return ans;
}

private void backtrack(int[] nums,
                       List<List<Integer>> ans,
                       List<Integer> list,
                       int idx) {

    // Add current subset
    ans.add(new ArrayList<>(list));

    // Explore further elements
    for (int i = idx; i < nums.length; i++) {

        // Skip duplicates at same recursion level
        if (i != idx && nums[i] == nums[i - 1]) {
            continue;
        }

        // Choose element
        list.add(nums[i]);

        // Recurse with next index
        backtrack(nums, ans, list, i + 1);

        // Backtrack
        list.remove(list.size() - 1);
    }
}
}