class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
         int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n - k + 1][m - k + 1];
        
        for(int i = 0; i <= n - k; i++){
            for(int j = 0; j <= m - k; j++){
                TreeSet<Integer> set = new TreeSet<>();
                
                for(int row = i; row < i + k ; row++){
                    for(int col = j; col < j + k; col++){

                        set.add(grid[row][col]);
                    }
                }

                if(set.size() <= 1){
                    continue;
                }

                

                Integer prev = null;
                int min = Integer.MAX_VALUE;
                for(int val : set){
                    if(prev != null){
                        min = Math.min(min , val - prev);
                    }
                    prev = val;
                }

                ans[i][j] = min;
            }
        }
        return ans;
    }
}