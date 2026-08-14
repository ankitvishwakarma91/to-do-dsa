class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (check(map)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public boolean check(Map<Character, Integer> map) {

        for (int val : map.values()) {
            if (val > 2) {
                return false;
            }
        }

        return true;
    }
}