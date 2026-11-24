class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int currentGCD = nums[i];
            int currentLCM = nums[i];
            long product = nums[i];

            for (int j = i; j < n; j++) {
                if (j > i) {
                    currentGCD = gcd(currentGCD, nums[j]);
                    currentLCM = lcm(currentLCM, nums[j]);
                    product *= nums[j];

                    if (product > (long) currentGCD * currentLCM) break;
                }

                if (product == (long) currentGCD * currentLCM) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private  int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private  int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    
}