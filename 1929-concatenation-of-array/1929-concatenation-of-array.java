class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int idx = 0;
        for(int i = 0; i<n; i++){
            ans[idx++] = nums[i];
        }
        for(int i = 0; i<n; i++){
            ans[idx++] = nums[i];
        }
        return ans;
    }
}