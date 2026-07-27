class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long max = Long.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int ans = (nums[i] - 1) * (nums[j] - 1);
        //         // System.out.println("i : " + nums[i] + " j : " + nums[j] + " = " + ans);
        //         max = Math.max(max, ans);
        //     }
        // }

        return (nums[n-1] - 1) * (nums[n-2] - 1);
    }
}