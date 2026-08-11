class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        
        // Step 1: Find the longest sequential prefix sum
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }
        
        // Step 2: Store all elements in a HashSet for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Step 3: Find the smallest integer >= sum that is missing from nums
        int ans = sum;
        while (set.contains(ans)) {
            ans++;
        }
        
        return ans;
    }
}