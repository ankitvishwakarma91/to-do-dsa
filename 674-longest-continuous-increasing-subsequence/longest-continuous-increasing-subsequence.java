class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        
        for (int i = 0; i < n; i++) {
            int curr = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j - 1] > nums[j] || nums[j-1] == nums[j]) {
                    max = Math.max(curr, max);
                    // curr = 1;
                    break;
                } else {
                    curr++;
                }
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}