class Solution {
    int n;
    int m;
    Integer[][][] dp;

    public int solve(int[][] grid, int row, int c1, int c2) {

        if (row >= n) {
            return 0;
        }

        int cherry = grid[row][c1];

        if (c1 != c2) {
            cherry += grid[row][c2];
        }

        if(dp[row][c1][c2] != null){
            return dp[row][c1][c2];
        }

        int ans = 0;
        for (int i = -1; i <= 1; i++) { // for rob 1  there are three option 
            for (int j = -1; j <= 1; j++) { // these are the three option for rob1 to move rob 2

                int newRow = row + 1;
                int newCol = c1 + i;
                int new_col = c2 + j;

                if (newCol >= m || new_col >= m || newCol < 0 || new_col < 0) {
                    continue;

                }

                ans = Math.max(ans, solve(grid, newRow, newCol, new_col));
            }
        }

        return dp[row][c1][c2] = ans + cherry;
    }

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[71][71][71];

        return solve(grid, 0, 0, m - 1);
    }
}