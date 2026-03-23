class Solution {

    public int solve(char[][] matrix, int i, int j, int[][]t) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] == '0') {
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        int right = solve(matrix, i, j + 1 , t);
        int down = solve(matrix, i + 1, j , t);
        int dia = solve(matrix, i + 1, j + 1 , t);

        return t[i][j] = 1 + Math.min(right, Math.min(down, dia));
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] t = new int[n][m];
        for(int[]arr:t){
            Arrays.fill(arr,-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, solve(matrix, i, j, t));
            }
        }
        return ans * ans;
    }
}