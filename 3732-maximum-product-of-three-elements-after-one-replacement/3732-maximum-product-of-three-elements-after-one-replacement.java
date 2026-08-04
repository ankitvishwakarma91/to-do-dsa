class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        final long X = 100000L;

        long smallest1 = nums[0];
        long smallest2 = nums[1];
        long largest1 = nums[n - 1];
        long largest2 = nums[n - 2];

        long option1 = smallest1 * smallest2 * X;
        long option2 = largest1 * largest2 * X;
        long option3 = smallest1 * largest1 * (-X);

        return Math.max(option1, Math.max(option2, option3));
    }
}