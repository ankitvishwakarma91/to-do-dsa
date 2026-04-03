class Solution {    

    Integer[][] dp[];

    public int solve(int[][] coins, int i, int j, int magic) {
        int n = coins.length;
        int m = coins[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return Integer.MIN_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && magic > 0) {
                return 0;
            }
            return coins[i][j];
        }

        if(dp[i][j][magic] != null) return dp[i][j][magic];

        int ans = Integer.MIN_VALUE;
        int right = solve(coins, i, j + 1, magic);
        if (right != Integer.MIN_VALUE) {
            ans = Math.max(ans, coins[i][j] + right);
        }

        int down = solve(coins, i + 1, j, magic);
        if (down != Integer.MIN_VALUE) {
            ans = Math.max(ans, coins[i][j] + down);
        }

        if (coins[i][j] < 0 && magic > 0) {
            // we have two option either we choose DownMax or rightMax
            int skipDown = solve(coins, i + 1, j, magic - 1);
            int skipRight = solve(coins, i, j + 1, magic - 1);
            int skip = Math.max(skipDown, skipRight);
            if (skip != Integer.MIN_VALUE) {
                ans = Math.max(ans, skip);
            }
        }

        return dp[i][j][magic] = ans;
    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        dp = new Integer[n][m][3];
        
        return solve(coins, 0, 0, 2);
    }
}