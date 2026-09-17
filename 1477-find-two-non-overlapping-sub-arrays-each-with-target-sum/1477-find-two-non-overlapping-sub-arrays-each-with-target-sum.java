class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int l = 0;
        int r = 0;

        int ans = Integer.MAX_VALUE;
        int cur = 0;

        
        int bestMin = Integer.MAX_VALUE;
        int[] minIdx = new int[n];
        Arrays.fill(minIdx, Integer.MAX_VALUE);
        while (r < n) {

            cur += arr[r];

            while ( l < r && cur > target) {
                cur -= arr[l];
                l++;
            }

            if (cur == target) {
                int len = r - l + 1;

                if (l > 0 && minIdx[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + minIdx[l - 1]);
                }

                bestMin = Math.min(bestMin, len);
            }

            minIdx[r] = bestMin;

            r++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}