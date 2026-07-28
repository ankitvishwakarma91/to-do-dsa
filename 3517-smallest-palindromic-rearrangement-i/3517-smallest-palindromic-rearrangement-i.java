class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        if (n == 1)
            return s;

        int k = n / 2;
        char[] arr = s.toCharArray();
        Arrays.sort(arr, 0, k);

        for (int i = 0; i < k; i++) {
            arr[n - 1 - i] = arr[i];
        }
        return new String(arr);
    }
}