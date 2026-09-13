class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        for (int i = -n + 1; i < n; i++) {
            for (int col = -n + 1; col < n; col++) {

                count = Math.max(count, countOverlaps(img1, img2, i, col));
            }
        }

        return count;
    }

    int countOverlaps(int[][] img, int[][] img1, int row, int col) {
        int n = img.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int validRow = i + row;
                int validCol = j + col;
                if (0 <= validRow && validRow < n && 0 <= validCol && validCol < n) {
                    cur += img[i][j] * img1[validRow][validCol];
                }
            }
        }
        return cur;
    }
}