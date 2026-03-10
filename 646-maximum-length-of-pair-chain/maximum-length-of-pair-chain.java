class Solution {
    public int solve(int[][] pairs, int idx, int prev, int[][] dp) {
        int n = pairs.length;
        if (idx >= n)
            return 0;

        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        int take = 0;
        if (prev == -1 || pairs[prev][1] < pairs[idx][0]) {
            // System.out.println(prev + " " + pairs[idx][1]);
            take = 1 + solve(pairs, idx + 1, idx, dp);
        }
        int notTake = solve(pairs, idx + 1, prev, dp);

        return dp[idx][prev + 1] = Math.max(take, notTake);
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[n][n+1];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        return solve(pairs, 0, -1, dp);
    }
}