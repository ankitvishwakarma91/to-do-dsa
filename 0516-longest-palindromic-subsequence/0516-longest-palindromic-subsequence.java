class Solution {

    public boolean check(String s) {
        int l = 0;
        int r = s.length();

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public int solve(String s, int i, int j, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];
        int take = 0;
        int skip = 0;
        if (s.charAt(i) == s.charAt(j)) {
            take = 2 + solve(s, i + 1, j - 1, dp);
        } else {
            skip = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
        }

        return dp[i][j] = Math.max(take, skip);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        return solve(s, 0, s.length() - 1, dp);
    }
}