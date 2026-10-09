class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int close = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (close % 2 == 1) {
                    ans++;
                    close--;
                }
                close += 2;
            } else {
                close--;

                if (close < 0) {
                    ans += 1;
                    close = 1;
                }
            }

        }

        return ans + close;
    }
}