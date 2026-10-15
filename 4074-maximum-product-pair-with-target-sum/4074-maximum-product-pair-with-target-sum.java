class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int f = -1, s = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j
                        && nums[i] > nums[j]
                        && nums[i] + nums[j] == target) {

                    int product = nums[i] * nums[j];

                    if (product > max) {
                        max = product;
                        f = i;
                        s = j;
                    }
                }
            }
        }

        return new int[]{f, s};

    }
}