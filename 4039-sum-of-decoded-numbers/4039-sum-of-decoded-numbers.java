class Solution {
    long mod = (long) 1e9 + 7;

    public int sumDecoded(long[] nums) {
        int n = nums.length;

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long width = nums[i] % 10;
            long d = (long) Math.floor(nums[i] / 10);

            String s = String.valueOf(d);
            long x = Long.parseLong(s.substring(0, (int) width));

            long y = Long.parseLong(s.substring((int) width, s.length()));

            long value = power(x, y);

            ans = (ans + value) % mod;
        }

        return (int) ans;
    }

    private long power(long x, long y) {

        long result = 1;
        x %= mod;

        while (y > 0) {

            // If y is odd
            if ((y & 1) == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            y /= 2;
        }

        return result;
    }
}