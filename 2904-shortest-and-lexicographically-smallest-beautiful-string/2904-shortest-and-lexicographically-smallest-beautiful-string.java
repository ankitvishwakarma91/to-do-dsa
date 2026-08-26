class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int i = 0;
        int j = 0;

        int cntOne = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        while (j < n) {

            char ch = s.charAt(j);
            if (ch == '1') {
                cntOne++;
            }

            while (cntOne == k) {
                int curLen = j - i + 1;
                String curr = s.substring(i, j + 1);
                if (curLen < min) {
                    min = curLen;
                    ans = curr;
                } else if (curLen == min) {
                    if (curr.compareTo(ans) < 0) {
                        ans = curr;
                    }
                }
                if (s.charAt(i) == '1') {
                    cntOne--;
                }
                i++;
            }
            j++;
        }

        return ans;
    }

}