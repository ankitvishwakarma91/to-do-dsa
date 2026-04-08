class Solution {

    int row;
    int col;
    int MOD = (int) 1e9 + 7;
    Integer dp[][][];

    public int solve(int maxMove, int i, int j, int move) {

        if (i < 0 || j < 0 || i >= row || j >= col)
            return 1;
        if (move >= maxMove)
            return 0;

        if (dp[i][j][move] != null)
            return dp[i][j][move];

        int left = solve(maxMove, i, j - 1, move + 1) % MOD;
        int right = solve(maxMove, i, j + 1, move + 1) % MOD;
        int down = solve(maxMove, i + 1, j, move + 1) % MOD;
        int up = solve(maxMove, i - 1, j, move + 1) % MOD;

        return dp[i][j][move] = ((left + right) % MOD + (down + up) % MOD) % MOD;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        row = m;
        col = n;
        dp = new Integer[m + 1][n + 1][maxMove + 1];
        return solve(maxMove, startRow, startColumn, 0);
    }
}