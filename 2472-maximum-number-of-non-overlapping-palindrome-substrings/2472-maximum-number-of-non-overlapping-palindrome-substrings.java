class Solution {
    int[][] dp;

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int solve(String s, int k, int i, int j) {
        int n = s.length();
        if (i >= n || j >= n) {
            return 0;
        }

      
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (isPalindrome(s, i, j)) {
           int take = 1 + solve(s, k, j + 1, j + k);
           int grow = solve(s, k, i, j + 1);
           int move = solve(s, k, i + 1, j + 1);

            return dp[i][j] = Math.max(grow, Math.max(take, move));
        }

       int  grow = solve(s, k, i, j + 1);
       int move = solve(s, k, i + 1, j + 1);

        return dp[i][j] = Math.max(grow, move);
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;
        dp = new int[n][n];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        return solve(s, k, 0, k - 1);
    }
}