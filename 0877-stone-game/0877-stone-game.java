class Solution {
    Integer[][] dp;

    public int solve(int[] piles, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int first = piles[i] + Math.min(solve(piles, i + 2, j), solve(piles, i + 1, j - 1));
        int sec = piles[j] + Math.min(solve(piles, i + 1, j - 1), solve(piles, i, j - 2));

        return dp[i][j] = Math.max(first, sec);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        dp = new Integer[n][n];
        int p1 = solve(piles, 0, n - 1);
        int total = 0;
        for (int i : piles) {
            total += i;
        }
        int p2 = total - p1;
        return p1 >= p2;
    }
}