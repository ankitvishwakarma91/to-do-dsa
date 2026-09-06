class Solution {


    public int solve(String s , String  t , int i , int j , int[][] dp){
        int n = s.length();
        int m = t.length();

        // if( i > n || j > m ) return 0;
        
        if(j == m ) return 1;
        if(i == n ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            ans += solve(s, t , i + 1, j+ 1 , dp);
        }

        return dp[i][j] = ans += solve(s, t , i + 1 , j , dp );
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(s, t , 0 , 0 , dp);
    }
}