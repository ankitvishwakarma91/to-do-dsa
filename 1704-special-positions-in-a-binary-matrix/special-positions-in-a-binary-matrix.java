class Solution {

    public boolean traversRow(int row, int col , int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < m; i++) {
            if (mat[row][i] == 1 && i != col ) {
                return false;
            }
        }
        return true;
    }

    public boolean traversCol( int row , int col, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            if (mat[i][col] == 1 && i != row) {
                return false;
            }
        }
        return true;
    }

    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (traversRow(i, j,  mat) && traversCol(i, j, mat)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}