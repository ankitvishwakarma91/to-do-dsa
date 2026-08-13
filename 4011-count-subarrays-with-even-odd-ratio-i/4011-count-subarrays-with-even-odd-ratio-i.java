class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int count = 0;
        int r = a / b;
        System.out.println("a/b  : " + a / b);
        for (int i = 0; i < n; i++) {

            int x = 0;
            int y = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    x++;
                } else if (nums[j] % 2 == 1) {
                    y++;
                }

                if (y > 0 && (long) b*x <= (long) a * y) {
                    // System.out.println("x/y  : " + x / y);
                    count++;
                }
            }
        }

        return count;
    }
}