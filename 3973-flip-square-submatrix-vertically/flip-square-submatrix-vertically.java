class Solution {

    // public void update(int[][] grid, int[][] ans , int x, int y , int )

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        // int[][] ans = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
                // if (i == x && j == y) {
                    int col = y;
                    int colEnd = y + k;
                    while (col < colEnd) {
                        int row = x;
                        int rowEnd = x + k - 1;
                        while (row < rowEnd) {
                            int temp = grid[row][col];
                            grid[row][col] = grid[rowEnd][col];
                            grid[rowEnd][col] = temp;
                            row++;
                            rowEnd--;
                        }
                        col++;
                    }
                // }
        //     }
        // }

        return grid;
    }
}