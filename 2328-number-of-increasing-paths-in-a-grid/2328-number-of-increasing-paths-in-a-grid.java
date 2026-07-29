class Solution {
    int m, n;
    int[][] directions = {
            { -1, 0 },
            { 0, -1 }, { 0, 1 },
            { 1, 0 }
    };

    int[][] t;
    long MOD = 1000000007;

    boolean isSafe(int i, int j) {
        return (i < m && i >= 0 && j < n && j >= 0);
    }

    int dfs(int[][] grid, int i, int j) {
        if (t[i][j] != -1) {
            return t[i][j];
        }

        long answer = 1;

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (isSafe(i_, j_) && grid[i_][j_] < grid[i][j]) {
                answer = (answer + dfs(grid, i_, j_)) % MOD;
            }
        }

        return t[i][j] = (int) answer;
    }

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new int[1001][1001];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        long result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = (result + dfs(grid, i, j)) % MOD;
            }
        }

        return (int) result;
    }

}