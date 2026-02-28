class Solution {

    public static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] == 'X') {
            return;
        }
        if (visited[i][j])
            return;
        if (board[i][j] == 'O' && !visited[i][j]) {
            visited[i][j] = true;
        }

        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j - 1, visited);
        dfs(board, i, j + 1, visited);

    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(board, i, m - 1, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, 0, i, visited);
            }
            if (board[n - 1][i] == 'O' && !visited[n - 1][i]) {
                dfs(board, n - 1, i, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        return;

    }
}