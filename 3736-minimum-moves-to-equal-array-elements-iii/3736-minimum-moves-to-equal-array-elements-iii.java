class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
        }
        int count = 0;
        for (int i : nums) {
            count += max - i;
        }

        return count;

    }
}