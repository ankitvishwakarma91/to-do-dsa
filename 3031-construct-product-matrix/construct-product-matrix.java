class Solution {
    int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] p = new int[n][m];

        /** This will not work  */
        // int prod = 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         prod = prod * grid[i][j];
        //     }
        // }

        // System.out.println(prod);

        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m ; j++){
        //         p[i][j] = (prod / grid[i][j]) % MOD;
        //     }
        // }


        /** Some Optimise */

        int[][] suffix = new int[n][m];
        long s = 1;
        for(int i = n - 1 ; i>=0; i--){
            for(int j = m - 1 ; j>=0; j--){
                suffix[i][j] = (int) s;
                s = (s * grid[i][j]) % MOD;
            }
        }

        for(int[] a : suffix){
            System.out.println(Arrays.toString(a));
        }

        long pr = 1;
        for(int i = 0; i<n ; i++){
            for(int j = 0; j< m ; j++){
                p[i][j] = (int) (suffix[i][j] * pr) % MOD;
                pr = (int) (pr * (grid[i][j] % MOD)) % MOD;
            }
        }

        return p;
    }
}