class Solution {
    

    // Give TLE , and sometime gives runtime error 
    // int[][] dp ;
    // public int solve(int[] nums, int i, int xor) {

    //     int n = nums.length;

    //     if (i == n)
    //         return xor != 0 ? 0 : -1000000;

    //     if(dp[i][xor] != -1) return dp[i][xor];

    //     int take = 1 + solve(nums, i + 1, (xor ^ nums[i]));
    

    //     int notTake = solve(nums, i + 1, xor);

    //     return dp[i][xor] = Math.max(take, notTake);

    // }

    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        // dp = new int[n][10000];

        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return solve(nums, 0, 0);

        boolean zero = false;

        int xor = 0;
        for(int i : nums){
            xor ^= i;

            if(i != 0){
                zero = true;
            }
        }

        if(xor != 0){
            return n;
        }

        if(zero){
            return n - 1;
        }

        return 0;
    }
}