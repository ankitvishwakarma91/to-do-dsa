class Solution {

    // public int solve(int[] nums , int x , int i , int j){

    // }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;
        for (int i : nums) {
            total += i;
        }

        int target = total - x;

        if(target < 0) return -1;
        if(target == 0) return n;

        int i = 0;
        int j = 0;
        int sum = 0;
        int max = -1;
        while (j < n) {

            sum += nums[j];

            while (i <= j && sum > target) {
                sum -= nums[i];
                i++;
            }
            if (sum == target) {
                max = Math.max(max, j - i + 1);
            }
            j++;
        }

        return max == -1 ? -1 : n - max;
    }
}