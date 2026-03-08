class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;

        if(n == 1) return -1;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n ; i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        int[] product = new int[n];
        product[n-1] = 1;
        for(int i = n - 2 ; i>=0; i--){
            product[i] = product[i+1] * nums[i+1];
        }

        // System.out.println(Arrays.toString(product));
        // System.out.println(Arrays.toString(prefixSum));

        for(int i= 1;i<n; i++){
            if(prefixSum[i] - nums[i] == product[i]){
                return i;
            }
        }
        return -1;
    }
}