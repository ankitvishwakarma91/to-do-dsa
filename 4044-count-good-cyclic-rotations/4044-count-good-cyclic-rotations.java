class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;

        int mid = n / 2;

        long first = 0;
        long total = 0;

        for (int i = 0; i < mid; i++) {
            first += nums[i];
        }
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        // System.out.println("first " + first);
        // System.out.println("second " + total);

        // int i = 0;
        // int j = mid;
        int count = 0;

        // if (first * 2 > total)
        //     count++;

        for (int i = 0; i < mid; i++) {
            if (2 * first != total) {
                count++;
            }

            first = first - nums[i] + nums[i + mid];
        }

        return count;
    }
}