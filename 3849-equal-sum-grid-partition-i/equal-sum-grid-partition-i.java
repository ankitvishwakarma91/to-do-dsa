class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] += grid[i][j];
                total += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        if (total % 2 != 0)
            return false;
        long upper = 0;
        for (int i = 0; i < n; i++) {
            upper += row[i];
            long lower = total - upper;
            if (upper == lower) {
                return true;
            }
        }

        long left = 0;
        for (int i = 0; i < m; i++) {
            left += col[i];
            long right = total - left;
            if (left == right) {
                return true;
            }
        }

        return false;

    }
}