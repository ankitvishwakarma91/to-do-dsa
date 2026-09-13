class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] temp = new int[n][n];
        int[][] ans = new int[n][n];   

        // rowshift
        for (int i = 0; i < n; i++) {
            int shift = rowShift[i];

            for (int j = 0; j < n; j++) {
                // ans[0][0] = grid[0][ ( )  ]
                temp[i][j] = grid[i][(j + shift) % n];
            }
        }


        System.out.println("After Row Shift");
        for(int[] ar : ans){
            System.out.println(Arrays.toString(ar));
        }

        // column shift
        for (int i = 0; i < n; i++) { // row
            int shift = colShift[i];

            for (int j = 0; j < n; j++) { // col
                // ans[row][col] = 0 , 1
                ans[j][i] = temp[(j+shift) % n][i];
            }
        }
        System.out.println("After Col Shift");
        for(int[] ar : ans){
            System.out.println(Arrays.toString(ar));
        }

        return ans;
    }
}