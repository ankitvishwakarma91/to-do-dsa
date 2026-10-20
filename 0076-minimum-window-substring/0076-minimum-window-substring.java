class Solution {
    public String minWindow(String s, String t) {
          int n = s.length();
        if (t.length() > n) {
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int required = t.length();
        int windowSize = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
    
        int start_i = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) > 0) {
                required--;
            }

            map.put(ch, map.getOrDefault(ch, 0)-1);



            while (required == 0) {
                int currWindowSize = j - i + 1;

                if (windowSize  > currWindowSize) {
                    windowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                map.put(startChar, map.getOrDefault(startChar, 0)+1);

                if (map.containsKey(startChar) && map.get(startChar) > 0) {
                    required++;
                }
                i++;
            }

            j++;
            
        }

        return windowSize == Integer.MAX_VALUE ? "": s.substring(start_i, start_i+windowSize);
    }
}