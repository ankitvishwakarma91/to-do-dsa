class Solution {
    int MOD = (int) 1e9 + 7;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        int n = nums.length;

        for (int[] q : queries) {
            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            while (idx <= r) {
                nums[idx] = (int) ((1L * nums[idx] * v) % MOD);
                idx += k;
            }

        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}