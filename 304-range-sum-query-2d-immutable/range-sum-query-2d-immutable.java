class NumMatrix {
    int[][] prefix;
    int n, m;

    public NumMatrix(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;

        this.prefix = new int[n][m];

        fillPrefixSum(prefix, matrix);
    }

    public void fillPrefixSum(int[][] prefix, int[][] mat) {
        prefix[0][0] = mat[0][0];
        // fill column 
        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] + mat[i][0];
        }

        // fill row
        for (int i = 1; i < m; i++) {
            prefix[0][i] = prefix[0][i - 1] + mat[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix[i][j] = mat[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];

        int extraLeft = (col1 > 0) ? prefix[row2][col1 - 1] : 0;
        int extraUp = (row1 > 0) ? prefix[row1 - 1][col2] : 0;
        int common = (row1 > 0 && col1 > 0) ? prefix[row1 - 1][col1 - 1] : 0;
        // return prefix[row2][col2] + prefix[row1 - 1][col1 - 1] - prefix[row2][col1 - 1] - prefix[row1 - 1][col2];

        return total + common - extraLeft - extraUp;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */