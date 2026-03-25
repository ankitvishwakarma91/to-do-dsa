class Solution {
    int[][] dp;
    public int solve(String s1 , String s2, int i , int j ){
        int n = s1.length();
        int m = s2.length();

        if(i == n ){
            return m - j;
        }else if( j == m){
            return n - i;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i + 1, j + 1);
        } 

        int insert = 1 + solve(s1 , s2 , i , j + 1 );
        int delete = 1 + solve(s1, s2 , i + 1 , j);
        int replace = 1 + solve(s1 , s2 , i + 1 , j + 1);

        return dp[i][j] = Math.min(insert , Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(word1, word2, 0, 0);
    }
}