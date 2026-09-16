class Solution {
    // int[][] dp;
    int mod = (int) 1e9 + 7;
    // tle
    // public int solve(int n, int k, int i) {
    //     if (k == 0)
    //         return 1;

    //     if (i >= n)
    //         return 0;

    //     if (dp[k][i] != -1) {
    //         return dp[k][i];
    //     }

    //     long take = 0;
    //     for (int j = i + 1; j <= n - 1; j++) {
    //         take = (take + solve(n, k - 1, j)) % mod;
    //     }
    //     long skip = solve(n, k, i + 1) % mod;

    //     return dp[k][i] = (int) (skip + take) % mod;
    // }

    public int helper(int n , int K){
        int[][] dp = new int[1001][1001];

        for(int i= 0; i<= n;i++){
            dp[0][i] = (i < n) ? 1 : 0;
        }

        for(int k = 1 ; k<=K; k++){

            int[] pre = new int[n+1];
            
            for(int j = n - 1 ; j>=0; j--){
                pre[j] = (int) ((pre[j+1] + dp[k-1][j]) % mod);
            }

            for(int i = n - 1 ; i>=0; i--){
                int skip = dp[k][i + 1];
                int take = pre[i + 1];
                // for(int j = i +1 ; j <= n - 1 ; j++){
                //     take = (take + dp[k-1][j]) % mod;
                // }
                dp[k][i] = (skip + take ) % mod;
            }
        }

        return dp[K][0];
    }

    public int numberOfSets(int n, int k) {
        // dp = new int[1001][1001];
        // for (int[] ar : dp) {
        //     Arrays.fill(ar, -1);
        // }
        // return solve(n, k, 0) % mod;
        return helper(n,k);
    }
}