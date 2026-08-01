class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int player1 = solve(nums, 0, n - 1);
        int player2 = sum - player1;

        return player1 >= player2;
    }

    public int solve(int[] nums, int i, int j) {
        int n = nums.length;

        if (i > n || j < 0) {
            return 0;
        }

        if (i > j) {
            return 0;
        }

        int first = nums[i] + Math.min(solve(nums, i + 2, j), solve(nums, i + 1, j - 1));
        int sec = nums[j] + Math.min(solve(nums, i + 1, j - 1), solve(nums, i, j - 2));

        return Math.max(first, sec);
    }
}
