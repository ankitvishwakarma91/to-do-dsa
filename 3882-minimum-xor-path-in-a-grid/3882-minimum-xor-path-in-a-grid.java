class Solution {
    Integer[][][] dp;
    public int solve(int[][] grid, int i, int j, int currVal) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return Integer.MAX_VALUE;
        }

        int sum = currVal ^ grid[i][j];
     
        if (i == n - 1 && j == m - 1) {
            return sum;
        }

        if(dp[i][j][sum] != null) return dp[i][j][sum];

        int right = solve(grid, i, j + 1, sum);
        int down = solve(grid, i + 1, j, sum);

        return dp[i][j][sum] = Math.min(right, down);
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m][1024];
        return solve(grid, 0, 0, 0);
    }
}