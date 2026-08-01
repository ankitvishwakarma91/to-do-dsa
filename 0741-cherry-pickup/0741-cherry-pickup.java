class Solution {
    Integer[][][][] dp;

    public int solve(int[][] grid, int r1, int c1, int r2, int c2) {
        int n = grid.length;
        int m = grid[0].length;

        if (r1 >= n || c1 >= m || r2 >= n || c2 >= m) {
            return Integer.MIN_VALUE;
        }

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == m - 1)
            return grid[n - 1][m - 1];

        if (dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];

        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2)
            cherries += grid[r2][c2];

        int p1 = solve(grid, r1 + 1, c1, r2 + 1, c2); // a person and b person go down 
        int p3 = solve(grid, r1 + 1, c1, r2, c2 + 1); // a down and b go right
        int p4 = solve(grid, r1, c1 + 1, r2 + 1, c2); // a go right and b go down
        int p2 = solve(grid, r1, c1 + 1, r2, c2 + 1); // a go right and b go right

        int best = Math.max(p1, Math.max(p2, Math.max(p3, p4)));
        if (best == Integer.MIN_VALUE)
            return dp[r1][c1][r2][c2] = Integer.MIN_VALUE;

        return dp[r1][c1][r2][c2] = cherries + best;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m][n][m];

        return Math.max(0, solve(grid, 0, 0, 0, 0));
    }
}