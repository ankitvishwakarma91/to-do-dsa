class Solution {

    public boolean solve(String s, int i, int j) {
        if (i >= j)
            return true;

        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }

        return solve(s, i + 1, j - 1);

    }

    public String longestPalindrome(String s) {
        int n = s.length();

        int max = Integer.MIN_VALUE;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j) && j - i + 1 > max) {
                    startIdx = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(startIdx, startIdx + max);
    }
}