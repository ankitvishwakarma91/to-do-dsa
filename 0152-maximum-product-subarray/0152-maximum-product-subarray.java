class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = nums[0];

        // for (int i = 0; i < n; i++) {
        //     int curr = 1;
        //     for (int j = i; j < n; j++) {
        //         curr *= nums[j];

        //         max = Math.max(curr, max);
        //     }
        // }
        // return max;

        // optimse 

        int leftSum = 1;
        int rightSum = 1;

        for (int i = 0; i < n; i++) {
            leftSum = (leftSum == 0) ? 1 : leftSum;
            rightSum = rightSum == 0 ? 1 : rightSum;

            leftSum *= nums[i];
            rightSum *= nums[n - 1 - i];

            max = Math.max(max, Math.max(leftSum, rightSum));
        }

        return max;

    }
}