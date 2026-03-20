class Solution {

    private boolean solve(int[] nums, int i, long target, long curr) {
        int n = nums.length;
        if (curr == target)
            return true;
        if (i == n || curr > target)
            return false;

        if (target % nums[i] == 0 && solve(nums, i + 1, target, curr * nums[i])) {
            return true;
        }
        return solve(nums, i + 1, target, curr);
    }

    public boolean checkEqualPartitions(int[] nums, long target) {

        long isValid = target * target;

        long product = 1;
        for (int val : nums) {
            product *= val;
        }

        if (isValid != product) {
            return false;
        }

        return solve(nums, 0, target, 1);
    }
}