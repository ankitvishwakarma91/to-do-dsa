class Solution {

    // public void BubbleSort(int )

    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] endZeros = new int[n];

        // fill endZeros array with no of trailing zeros. 
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                }else{
                    break;
                }
            }
            endZeros[i] = count;
        }

        // System.out.println(Arrays.toString(endZeros));

        int steps = 0;
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;

            int j = i;

            while (j < n && endZeros[j] < need) {
                j++;
            }

            if (j == n)
                return -1;

            steps += (j - i);

            while (j > i) {
                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;
            }
        }

        return steps;
    }

}