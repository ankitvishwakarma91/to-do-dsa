class Solution {

    public void dfs(char[][] grid,int i , int j, boolean[][] visited ){
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == '0'){
            return;
        }

        visited[i][j] = true;
        dfs(grid, i + 1 , j , visited);
        dfs(grid, i - 1 , j , visited);
        dfs(grid, i , j +  1, visited);
        dfs(grid, i , j - 1, visited);
        
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j ,visited);
                    count++;
                }
            }
        }
        return count;
    }
}