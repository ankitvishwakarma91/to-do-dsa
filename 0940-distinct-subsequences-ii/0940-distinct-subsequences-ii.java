class Solution {

    // TLE 
    // public static void  solve(int i ,String curr, String s , HashSet<String> set){
    //     int n= s.length();
    //     if(i == n){
    //         set.add(curr);
    //         return;
    //     }

    //     solve(i+1,curr + s.charAt(i),s,set);
    //     solve(i+1,curr,s,set);
    // }
    public int distinctSubseqII(String s) {

        // HashSet<String> set = new HashSet<>();

        // solve(0,"",s,set);
        // return set.size()-1;

        int n = s.length();
        int mod = 1000000007;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            dp[i] = (2 * dp[i - 1]) % mod;

            // If character was seen before, remove duplicate subsequences
            if (last.containsKey(ch)) {
                int j = last.get(ch);
                dp[i] = (dp[i] - dp[j - 1] + mod) % mod;
            }

            last.put(ch, i);

        }
        return (dp[n] - 1 + mod) % mod;

    }
}