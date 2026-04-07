class Solution {

    Integer[][][] dp;
    int MOD = (int) 1e9 + 7;
    public int solve(int n , int min , int[] group , int[] profit  , int i , int p , int m){
        
        if(m > n) return 0;

        if( i == group.length){
            if(p >= min){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i][p][m] != null) return dp[i][p][m];

        int notTake = solve(n , min , group, profit, i + 1 , p , m) % MOD;

        int take = solve(n , min , group , profit, i + 1 , Math.min(min , p + profit[i]), m + group[i]) % MOD;

        return dp[i][p][m] = (take + notTake) % MOD;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // int n = group.length;
        dp = new Integer[101][101][101];
        return solve(n , minProfit, group, profit, 0, 0, 0);
    }
}