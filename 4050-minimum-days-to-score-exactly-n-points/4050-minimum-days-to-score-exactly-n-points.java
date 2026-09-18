class Solution {

    // public int solve(int n, int days, int streak, int curr) {

    //     if (curr == n) {
    //         return 0;
    //     }

    //     if (curr > n) {
    //         return Integer.MAX_VALUE;
    //     }

    //     int take = 1 + solve(
    //             n,
    //             days + 1,
    //             streak + 1,
    //             curr + streak + 1);

    //     int skip = solve(
    //             n,
    //             days + 1,
    //             0,
    //             curr);

    //     return Math.min(take, skip);
    // }

    public int minDays(int n) {
        // return solve(n, 0, 0, 0);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = -1;
        for (int score = 1; score <= n; score++) {
            for (int k = 1; k * (k + 1) / 2 <= score; k++) {
                int p = k * (k + 1) / 2;

                if (dp[score - p] != Integer.MAX_VALUE) {
                    dp[score] = Math.min(dp[score], dp[score - p] + k + 1);
                }
            }
        }
        return dp[n];
    }
}