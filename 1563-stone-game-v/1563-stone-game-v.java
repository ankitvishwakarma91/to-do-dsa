class Solution {

    // What I was thinking is it is a binarySearch Problem because we divide it in middle but it's not we should check
    // every possible split 

    Integer[][] dp;

    public int solve(int l, int r, int[] prefix) {

        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != null)
            return dp[l][r];
        int alice = 0;
        for (int mid = l; mid <= r; mid++) {
            int left = prefix[mid] - (l - 1 >= 0 ? prefix[l - 1] : 0);
            int right = prefix[r] - prefix[mid];

            if (left > right) {
                alice = Math.max(alice, right + solve(mid + 1, r, prefix));
            } else if (left < right) {
                alice = Math.max(alice, left + solve(l, mid, prefix));
            } else {
                alice = Math.max(
                        left + solve(l, mid, prefix),
                        right + solve(mid + 1, r, prefix));
            }
        }
        return dp[l][r] = alice;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        if (n == 1)
            return 0;

        dp = new Integer[n][n];
        int[] prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stoneValue[i];
        }

        return solve(0, n - 1, prefix);

    }

    // public int calSum(int[] arr, int i, int j) {
    //     int sum = 0;
    //     for (int k = i; k <= j; k++) {
    //         sum += arr[k];
    //     }

    //     return sum;
    // }
}