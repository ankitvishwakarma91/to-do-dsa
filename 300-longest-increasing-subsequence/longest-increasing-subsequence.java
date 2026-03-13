class Solution {

    public int solve(int[] nums, int i, int prevIdx , int[][] dp) {
        int n = nums.length;
        if (i >= n)
            return 0;

        if(dp[i][prevIdx+1] != -1) return dp[i][prevIdx+1];

        int take = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[i]) {
            take = 1 + solve(nums, i + 1, i , dp);
        }

        int notTake = solve(nums, i + 1, prevIdx , dp);

        return dp[i][prevIdx+1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return solve(nums, 0, -1 , dp);
    }
}