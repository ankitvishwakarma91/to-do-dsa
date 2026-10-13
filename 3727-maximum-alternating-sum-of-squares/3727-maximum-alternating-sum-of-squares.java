class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] * nums[i];
        }

        // even -> n/2 , odd -> (n/2)+ 1;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < n / 2; i++) {
            minSum += arr[i];
        }
        for (int i = n / 2; i < n; i++) {
            maxSum += arr[i];
        }

        

        return maxSum - minSum;
    }
}