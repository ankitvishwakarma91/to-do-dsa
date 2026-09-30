class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if(n == 0) return 0;

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        while (j < n) {
            char ch = s.charAt(j);

            while (set.contains(ch)) {
                max = Math.max(max, j - i);
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}