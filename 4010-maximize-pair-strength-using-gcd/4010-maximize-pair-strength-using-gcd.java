class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = i + 1 ; j < n ; j++){
                long val =(long) nums[i] * nums[j];
                long sq = gcd(nums[i],nums[j]);
                long cur = val / ((long)sq * sq);
                max = Math.max(cur, max);
            }
        }

        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}