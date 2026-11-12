class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int max = 0;
        // increasing

        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    cur++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cur);
        }

        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[j - 1]) {
                    cur++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}