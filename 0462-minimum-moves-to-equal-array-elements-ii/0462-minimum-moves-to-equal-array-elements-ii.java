class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int operation = 0, mid = nums[nums.length/2];
        for(int i : nums){
            operation += Math.abs(mid - i);
        }
        return operation;
    }
}