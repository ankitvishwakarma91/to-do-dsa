class Solution {

    static int MOD = 1_000_000_007;
    static int[][][] dp;

    public int solve(int zero, int one, int limit, int lastWasOne) {
        if (zero == 0 && one == 0) {
            return 1;
        }

        if(dp[zero][one][lastWasOne] != -1) return dp[zero][one][lastWasOne];

        int result = 0;
        if (lastWasOne == 1) { // then we explore zero
            for (int i = 1; i <= Math.min(limit, zero); i++) {
                result = (result + solve(zero - i , one, limit, 0)) % MOD;
            }
        } else { // then we explore one

            for (int i = 1; i <= Math.min(limit, one); i++) {
                result = (result + solve(zero , one - i, limit, 1)) % MOD;
            }
        }

        return dp[zero][one][lastWasOne] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[201][201][2];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        int startWithOne = solve(zero, one, limit, 1);
        int startWithZero = solve(zero, one, limit, 0);

        return (startWithOne + startWithZero) % MOD;
    }
}