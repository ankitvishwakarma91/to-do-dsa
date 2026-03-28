class Solution {
    // int min = Integer.MAX_VALUE;
    int[] dp;
    public int solve(int i , int[] cost){
        int n = cost.length;
        if( i >= n ) return 0;
        if(dp[i] != -1) return dp[i];
        int oneStep = cost[i] + solve(i + 1, cost);

    
        int twoStep = cost[i] + solve(i + 2 , cost);
        

        return dp[i] =  Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int zeroIdx = solve(0, cost);
        int oneIdx = solve(1, cost);

        return Math.min(zeroIdx,oneIdx);

    }
}