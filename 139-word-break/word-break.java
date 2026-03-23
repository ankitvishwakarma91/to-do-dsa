class Solution {

    public boolean solve(String s, int idx, List<String> word, Boolean[] memo) {
        int n = s.length();
        if (idx == n)
            return true;

        if(memo[idx] != null) return memo[idx];

        for (int i = idx + 1; i <= n; i++) {
            String curr = s.substring(idx, i);

            if (word.contains(curr) && solve(s, i, word , memo)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] memo = new Boolean[n];
        return solve(s, 0, wordDict, memo);

    }
}