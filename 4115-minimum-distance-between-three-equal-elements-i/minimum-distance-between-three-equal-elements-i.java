class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return -1;
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k] && nums[i] == nums[k] ) {
                        int minA = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        min = Math.min(minA, min);
                        found = true;
                    }
                }
            }
        }

        if(!found) return -1;

        return min;
    }
}