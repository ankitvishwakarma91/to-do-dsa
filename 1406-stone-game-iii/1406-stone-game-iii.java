class Solution {
    int n;
    int[] dp;

    public int solve(int[] stone, int idx) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        dp[idx] = stone[idx] - solve(stone, idx + 1);

        if (idx + 1 < n) {
            dp[idx] = Math.max(dp[idx], stone[idx] + stone[idx + 1] - solve(stone, idx + 2));
        }
        // int three = 0;
        if (idx + 2 < n) {
            dp[idx] = Math.max(dp[idx], stone[idx] + stone[idx + 2] + stone[idx + 1] - solve(stone, idx + 3));
        }
        return dp[idx];
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = solve(stoneValue, 0);
        if (ans < 0) {
            return "Bob";
        } else if (ans > 0) {
            return "Alice";
        } else {
            return "Tie";
        }
    }
}