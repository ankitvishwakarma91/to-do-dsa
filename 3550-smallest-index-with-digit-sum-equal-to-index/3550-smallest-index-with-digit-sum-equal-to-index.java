class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int count = 0;
        if(nums[0] == 0){
            return 0;
        }
        for (int i = 1; i < n; i++) {

            int sum = 0;

            while (nums[i] > 0) {
                sum += nums[i] % 10;
                nums[i] /= 10;
            }

            System.out.println("for i " + i + " sum : " + sum);
            if (sum == i) {
                return i;
            }

        }

        return -1;
    }
}