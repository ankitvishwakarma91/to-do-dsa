class Solution {
    public int minMoves(int[] nums) {

        int n = nums.length;
        long maxSum = 0;

        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            maxSum += nums[i];
            min = Math.min(min,nums[i]);
        }

        int req = (int) (maxSum - (long)min * n) ;

        return req;

    }
}