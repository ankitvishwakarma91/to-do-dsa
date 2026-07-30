class Solution {
    public int minimumPushes(String word) {
        int len = word.length();

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int sum = 0;
        int idx = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            sum += freq[i] * (idx / 8 + 1);
            idx++;
        }

        return sum;

    }
}